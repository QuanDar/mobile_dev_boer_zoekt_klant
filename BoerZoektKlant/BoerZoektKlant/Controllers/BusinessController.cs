using BoerZoektKlant.Models;
using BoerZoektKlant.Models.App;
using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BoerZoektKlant.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class BusinessController : Controller
    {
        RepositoryDbContext _context;

        public BusinessController(RepositoryDbContext context)
        {
            _context = context;
        }

        [HttpGet]
        public ActionResult<List<Business>> GetAll()
        {
            return _context.Businesses.ToList();
        }
    }
}