using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace NutritiveMealSystem.TraceabilityServices.Models.ReturnModels
{
    public class PlantInfoStatus : Status
    {
        public PlantInfoStatus(bool state) : base(state)
        {
        }
        public List<TPlantInfo> PlantInfos { get; set; }
    }
}
