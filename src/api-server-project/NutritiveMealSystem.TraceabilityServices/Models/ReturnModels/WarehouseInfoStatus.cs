using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace NutritiveMealSystem.TraceabilityServices.Models.ReturnModels
{
    public class WarehouseInfoStatus : Status
    {
        public WarehouseInfoStatus(bool state) : base(state)
        {
        }
        public List<TWarehouseInfo> Warehouses { get; set; }

    }
}
