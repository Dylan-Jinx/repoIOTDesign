using System;
using System.Collections.Generic;

namespace NutritiveMealSystem.TraceabilityServices.Models
{
    public partial class TProductionBaseStaff
    {
        public int Id { get; set; }
        public string StaffName { get; set; }
        public string Telephone { get; set; }
        public string ProductionBaseName { get; set; }
        public string Image { get; set; }
        public string Position { get; set; }
    }
}
