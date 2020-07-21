using System;
using System.Collections.Generic;

namespace NutritiveMealSystem.TraceabilityServices.Models
{
    public partial class TWaterQualityInfo
    {
        public int Id { get; set; }
        public DateTime? DateOfSampling { get; set; }
        public double? Ph { get; set; }
        public string ComprehensiveEvaluation { get; set; }
        public string Remark { get; set; }
        public string Image { get; set; }
    }
}
