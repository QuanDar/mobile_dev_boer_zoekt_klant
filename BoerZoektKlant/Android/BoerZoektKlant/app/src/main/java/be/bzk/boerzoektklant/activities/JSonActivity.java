package be.bzk.boerzoektklant.activities;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import be.bzk.boerzoektklant.R;
import be.bzk.boerzoektklant.data.models.Business;
import be.bzk.boerzoektklant.data.models.UserInfoDTO;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class JSonActivity extends AppCompatActivity {

    // Use JSONObject to parse json string button.
    private Button parseJsonUseJSONObjectButton = null;

    // Use GSON to parse json string button.
    private Button parseJsonUseGSONButton = null;

    // Clear parse result text view content button.
    private Button parseResultClearButton = null;

    // Display parsed json result text view.
    private TextView showJsonParseResultTextView = null;

    // Waiting for child thread message and display parsed out json text in text view.
    private Handler updateUIHandler = null;

    // Message type.
    private final int MESSAGE_SHOW_PARSE_RESULT = 1;

    // Save parsed out json string bundle key.
    private final String KEY_RESULT_DATA = "KEY_RESULT_DATA";

    // Used to access json url page and get response data.
    private static OkHttpClient okHttpClient = null;

    // This is the json file url.
    private String jsonFileUrl = "10.95.1.31/api/businesses";

    // Log debug or error message tag.
    private static final String TAG_JSON_EXAMPLE = "TAG_JSON_EXAMPLE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_example);

        setTitle("dev2qa.com - Android JSON Example.");

        // Init UI controls.
        initControls();

        // Click this button to parse url json string with JSONObject.
        parseJsonUseJSONObjectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Create a callback object.
                Callback callback = new Callback() {

                    // If read json file failure.
                    @Override
                    public void onFailure(Call call, IOException e) {
                        // Display error message in text view.
                        sendDisplayParseJsonResultMessage(e.getMessage());
                        Log.e(TAG_JSON_EXAMPLE, e.getMessage(), e);
                    }

                    // If read json file success.
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                        if(response.isSuccessful())
                        {
                            // Get json string.
                            String jsonString = response.body().string();

                            // Use JSONObject to parse json string.
                            String parsedString = parseJSONWithJSONObject(jsonString);

                            // Display parse result.
                            sendDisplayParseJsonResultMessage(parsedString);
                        }
                    }
                };

                // Send http get request to json page url.
                sendHttpGetRequest(jsonFileUrl, callback);
            }
        });


        // Click this button to parse json string use GSON.
        parseJsonUseGSONButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a callback object.
                Callback callback = new Callback() {

                    // If read json file url failure.
                    @Override
                    public void onFailure(Call call, IOException e) {
                        sendDisplayParseJsonResultMessage(e.getMessage());
                        Log.e(TAG_JSON_EXAMPLE, e.getMessage(), e);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                        // If read json file url success.
                        if(response.isSuccessful())
                        {
                            // Get json string.
                            String jsonString = response.body().string();

                            // Use GSON to parse json string.
                            String parsedString = parseJSONWithGSON(jsonString);

                            // Show parsed out string in text view.
                            sendDisplayParseJsonResultMessage(parsedString);
                        }
                    }
                };

                // Send http get request to json page url.
                sendHttpGetRequest(jsonFileUrl, callback);
            }
        });

        // Click this button to clear bottom json parsed result text view content.
        parseResultClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showJsonParseResultTextView.setText("");
            }
        });

    }

    // Initialize UI controls.
    private void initControls()
    {
        if(parseJsonUseJSONObjectButton == null)
        {
            parseJsonUseJSONObjectButton = (Button)findViewById(R.id.parse_json_use_jsonobject_button);
        }

        if(parseJsonUseGSONButton == null)
        {
            parseJsonUseGSONButton = (Button)findViewById(R.id.parse_json_use_gson_button);
        }

        if(parseResultClearButton == null)
        {
            parseResultClearButton = (Button)findViewById(R.id.parse_json_clear_text_view_button);
        }

        if(showJsonParseResultTextView == null)
        {
            showJsonParseResultTextView = (TextView)findViewById(R.id.parse_json_result_text_view);
        }

        if(updateUIHandler == null)
        {
            // This handler wait for child thread message to update UI.
            // This can avoid update UI in child thread which can cause error.
            updateUIHandler = new Handler()
            {
                @Override
                public void handleMessage(Message msg) {
                    // If message means show json parse result.
                    if(msg.what == MESSAGE_SHOW_PARSE_RESULT)
                    {
                        // Get message saved data.
                        Bundle bundle = msg.getData();
                        String resultData = bundle.getString(KEY_RESULT_DATA);

                        // Show parsed result.
                        showJsonParseResultTextView.setText(resultData);
                    }
                }
            };
        }

        if(okHttpClient == null)
        {
            okHttpClient = new OkHttpClient();
        }
    }

    /* Send http get request to url.
     *  The callback input parameter is used to receive server response data.
     * */
    public void sendHttpGetRequest(String url, okhttp3.Callback callback)
    {
        // Create a OkHttpClient request builder.
        Request.Builder builder = new Request.Builder();

        // Set xml file url.
        builder  = builder.url(url);

        // Build http request.
        Request request = builder.build();

        // Create a OkHttp3 Call object.
        Call call = okHttpClient.newCall(request);

        // Execute the get xml file request asynchronously in an automate child thread.
        call.enqueue(callback);
    }

    /* Use JSONObject to parse json string, return formatted string. */
    public String parseJSONWithJSONObject(String jsonString)
    {
        StringBuffer retBuf = new StringBuffer();

        try {
            // Create a JSONArray.
            JSONArray jsonArray = new JSONArray(jsonString);

            // Get the json array length and loop for each json object.
            int arrayLength = jsonArray.length();

            for(int i = 0; i < arrayLength; i++)
            {
                // Get each json object.
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);

                // Get each json filed value.
                String user = jsonObject.getString("user");
                String email = jsonObject.getString("email");
                String title = jsonObject.getString("title");

                retBuf.append("\r\nuser = " + user);
                retBuf.append("\r\nemail = " + email);
                retBuf.append("\r\ntitle = " + title);
                retBuf.append("\r\n**************************");
            }
        }catch(JSONException ex)
        {
            Log.e(TAG_JSON_EXAMPLE, ex.getMessage(), ex);
            retBuf.append(ex.getMessage());
        }finally {
            return retBuf.toString();
        }
    }

    /* Use GSON to parse json string, return formatted string. */
    public String parseJSONWithGSON(String jsonString)
    {
        StringBuffer retBuf = new StringBuffer();

        // Create a Gson object.
        Gson gson = new Gson();

        // Create a TypeToken. Because our jason file contains multiple json object, so the TypeToken is a list of UserInfoDTO.
        TypeToken<List<Business>> typeToken = new TypeToken<List<Business>>(){};

        // Get the type list from json string.
        List<Business> userInfoDTOList = gson.fromJson(jsonString, typeToken.getType());

        // Loop the user info dto list.
        for(Business userInfoDto : userInfoDTOList)
        {
            retBuf.append("\r\ndescription = " + userInfoDto.getDescription());
            retBuf.append("\r\nexcerpt = " + userInfoDto.getExcerpt());
            retBuf.append("\r\ntitle = " + userInfoDto.getTitle());
            retBuf.append("\r\n**************************");
        }
        return retBuf.toString();
    }

    /* Send display text message to activity main thread Handler to show text in text view.*/
    public void sendDisplayParseJsonResultMessage(String text)
    {
        // Create a message.
        Message message = new Message();

        // Set message type.
        message.what = MESSAGE_SHOW_PARSE_RESULT;

        // Create a bundle and set data.
        Bundle bundle = new Bundle();
        bundle.putString(KEY_RESULT_DATA, text);
        message.setData(bundle);

        // Send the message to main thread handler.
        updateUIHandler.sendMessage(message);
    }
}
