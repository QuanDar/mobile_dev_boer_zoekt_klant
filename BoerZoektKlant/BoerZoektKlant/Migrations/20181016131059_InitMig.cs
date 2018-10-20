using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Migrations;

namespace BoerZoektKlant.Migrations
{
    public partial class InitMig : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "BusinessCategorieses",
                columns: table => new
                {
                    BusinessId = table.Column<int>(nullable: false),
                    CategoryId = table.Column<int>(nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_BusinessCategorieses", x => new { x.BusinessId, x.CategoryId });
                });

            migrationBuilder.CreateTable(
                name: "Businesses",
                columns: table => new
                {
                    Id = table.Column<int>(nullable: false)
                        .Annotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn),
                    Title = table.Column<string>(nullable: true),
                    Description = table.Column<string>(nullable: true),
                    Excerpt = table.Column<string>(nullable: true),
                    ImageUrl = table.Column<string>(nullable: true),
                    Rating = table.Column<int>(nullable: false),
                    PhoneNumber = table.Column<string>(nullable: true),
                    BusinessCategoriesBusinessId = table.Column<int>(nullable: true),
                    BusinessCategoriesCategoryId = table.Column<int>(nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Businesses", x => x.Id);
                    table.ForeignKey(
                        name: "FK_Businesses_BusinessCategorieses_BusinessCategoriesBusinessId_BusinessCategoriesCategoryId",
                        columns: x => new { x.BusinessCategoriesBusinessId, x.BusinessCategoriesCategoryId },
                        principalTable: "BusinessCategorieses",
                        principalColumns: new[] { "BusinessId", "CategoryId" },
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "Categories",
                columns: table => new
                {
                    Id = table.Column<int>(nullable: false)
                        .Annotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn),
                    Name = table.Column<string>(nullable: true),
                    BusinessCategoriesBusinessId = table.Column<int>(nullable: true),
                    BusinessCategoriesCategoryId = table.Column<int>(nullable: true),
                    BusinessId = table.Column<int>(nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Categories", x => x.Id);
                    table.ForeignKey(
                        name: "FK_Categories_Businesses_BusinessId",
                        column: x => x.BusinessId,
                        principalTable: "Businesses",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Restrict);
                    table.ForeignKey(
                        name: "FK_Categories_BusinessCategorieses_BusinessCategoriesBusinessId_BusinessCategoriesCategoryId",
                        columns: x => new { x.BusinessCategoriesBusinessId, x.BusinessCategoriesCategoryId },
                        principalTable: "BusinessCategorieses",
                        principalColumns: new[] { "BusinessId", "CategoryId" },
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "Prices",
                columns: table => new
                {
                    Id = table.Column<int>(nullable: false)
                        .Annotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn),
                    Name = table.Column<string>(nullable: true),
                    Price = table.Column<double>(nullable: false),
                    BusinessId = table.Column<int>(nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Prices", x => x.Id);
                    table.ForeignKey(
                        name: "FK_Prices_Businesses_BusinessId",
                        column: x => x.BusinessId,
                        principalTable: "Businesses",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateIndex(
                name: "IX_Businesses_BusinessCategoriesBusinessId_BusinessCategoriesCategoryId",
                table: "Businesses",
                columns: new[] { "BusinessCategoriesBusinessId", "BusinessCategoriesCategoryId" });

            migrationBuilder.CreateIndex(
                name: "IX_Categories_BusinessId",
                table: "Categories",
                column: "BusinessId");

            migrationBuilder.CreateIndex(
                name: "IX_Categories_BusinessCategoriesBusinessId_BusinessCategoriesCategoryId",
                table: "Categories",
                columns: new[] { "BusinessCategoriesBusinessId", "BusinessCategoriesCategoryId" });

            migrationBuilder.CreateIndex(
                name: "IX_Prices_BusinessId",
                table: "Prices",
                column: "BusinessId");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Categories");

            migrationBuilder.DropTable(
                name: "Prices");

            migrationBuilder.DropTable(
                name: "Businesses");

            migrationBuilder.DropTable(
                name: "BusinessCategorieses");
        }
    }
}
