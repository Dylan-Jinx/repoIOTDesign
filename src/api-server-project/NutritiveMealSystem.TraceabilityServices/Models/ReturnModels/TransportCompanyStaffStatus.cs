using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace NutritiveMealSystem.TraceabilityServices.Models.ReturnModels
{
    public class TransportCompanyStaffStatus : Status
    {
        public TransportCompanyStaffStatus(bool state) : base(state)
        {
        }
        public List<TTransportCompanyStaff> Staffs { get; set; }
    }
}
