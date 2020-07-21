using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace NutritiveMealSystem.TraceabilityServices.Models.ReturnModels
{
    public class TransportationCompanyInfoStatus : Status
    {
        public TransportationCompanyInfoStatus(bool state) : base(state)
        {
        }
        public List<TTransportationCompanyInfo> CompanyInfos { get; set; }
    }
}
