using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using BoerZoektKlant.Models.App;
using Microsoft.EntityFrameworkCore;

namespace BoerZoektKlant.Models
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
        }
    }
}
