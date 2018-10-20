using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BoerZoektKlant_BackEnd.Models.App
{
    public class BusinessCategories
    {
        public int BusinessId { get; set; }
        public List<Business> Businesses { get; set; }
        public int CategoryId { get; set; }
        public List<Category> Categories { get; set; }


    }
}
