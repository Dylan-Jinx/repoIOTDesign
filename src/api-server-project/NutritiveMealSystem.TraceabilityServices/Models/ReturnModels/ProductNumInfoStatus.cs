using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace NutritiveMealSystem.TraceabilityServices.Models.ReturnModels
{
    public class ProductNumInfoStatus : Status
    {
        public ProductNumInfoStatus(bool state) : base(state)
        {
        }
        public List<TProductNumInfo> Products { get; set; }
    }
}
