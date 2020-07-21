using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace NutritiveMealSystem.TraceabilityServices.Models.ReturnModels
{
    public class WaterQualityStatus : Status
    {
        public WaterQualityStatus(bool state) : base(state)
        {
        }
        public List<TWaterQualityInfo> WaterQualityInfos { get; set; }
    }
}
