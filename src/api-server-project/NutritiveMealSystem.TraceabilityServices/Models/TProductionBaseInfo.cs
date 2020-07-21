using System;
using System.Collections.Generic;

namespace NutritiveMealSystem.TraceabilityServices.Models
{
    public partial class TProductionBaseInfo
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public string Category { get; set; }
        public string ResponsibleName { get; set; }
        public string Telephone { get; set; }
        public string Image { get; set; }
    }
}
