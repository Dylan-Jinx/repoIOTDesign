using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace NutritiveMealSystem.TraceabilityServices.Models.ReturnModels
{
    public class ProductionBaseInfoStatus : Status
    {
        public ProductionBaseInfoStatus(bool state) : base(state)
        {
        }
        public List<TProductionBaseInfo> ProductionBaseInfos { get; set; }
    }
}
