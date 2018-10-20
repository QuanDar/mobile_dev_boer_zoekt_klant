using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using BoerZoektKlant_BackEnd.Models.App;
using Microsoft.EntityFrameworkCore;

namespace BoerZoektKlant_BackEnd.Models
{
    public class RepositoryDbContext : DbContext
    {
        public RepositoryDbContext()
        {
        }

        public RepositoryDbContext(DbContextOptions<RepositoryDbContext> options) : base(options)
        {

        }
        public DbSet<Business> Businesses { get; set; }
        public DbSet<Category> Categories { get; set; }
        public DbSet<Prices> Prices { get; set; }
        public DbSet<BusinessCategories> BusinessCategorieses { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<BusinessCategories>().HasKey(
                table => new { table.BusinessId, table.CategoryId });

            modelBuilder.Entity<Business>().HasData(
                new Business
                {
                    Id = 1,
                    Description = "Description",
                    Rating = 4,
                    Title = "Super Titel",
                    Excerpt = "This is an excerpt"
                },
                new Business
                {
                    Id = 2,
                    Description = "Description asdas dasfads fwsewgf sergdrfgh rdegh",
                    Rating = 3,
                    Title = "Super Titel",
                    Excerpt = "This is an excerpt"
                }
                );

        }

    }
}
