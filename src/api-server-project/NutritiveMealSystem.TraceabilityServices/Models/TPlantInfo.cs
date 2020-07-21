using System;
using System.Collections.Generic;

namespace NutritiveMealSystem.TraceabilityServices.Models
{
    public partial class TPlantInfo
    {
        public int Id { get; set; }
        public string SeedSource { get; set; }
        public string PlantFieldNum { get; set; }
        public DateTime? PlantTime { get; set; }
        public DateTime? HarvestTime { get; set; }
        public string Remark { get; set; }
    }
}
