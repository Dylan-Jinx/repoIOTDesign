using NutritiveMealSystem.TraceabilityServices.Models.ReturnModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace NutritiveMealSystem.TraceabilityServices.Models
{
    public class ProductionBaseStaffStatus : Status
    {
        public ProductionBaseStaffStatus(bool state) : base(state)
        {
        }
        public List<TProductionBaseStaff> Staffs { get; set; }
    }
}
