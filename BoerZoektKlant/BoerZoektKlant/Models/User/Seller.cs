using BoerZoektKlant.Models.App;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BoerZoektKlant.Models.User
{
    public class Seller
    {
        public int Id { get; set; }
        public string IdentityId { get; set; }
        public AppUser Identity { get; set; }
        public Business Business { get; set; }
    }
}
