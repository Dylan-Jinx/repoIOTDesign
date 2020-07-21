using System;
using System.Collections.Generic;

namespace NutritiveMealSystem.TraceabilityServices.Models
{
    public partial class TTransportCompanyStaff
    {
        public int Id { get; set; }
        public string StaffName { get; set; }
        public string Telephone { get; set; }
        public string TransPortCompanyName { get; set; }
        public string Image { get; set; }
    }
}
