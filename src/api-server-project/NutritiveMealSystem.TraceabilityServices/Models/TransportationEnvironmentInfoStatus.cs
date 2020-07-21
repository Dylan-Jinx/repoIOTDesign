using NutritiveMealSystem.TraceabilityServices.Models.ReturnModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace NutritiveMealSystem.TraceabilityServices.Models
{
    public class TransportationEnvironmentInfoStatus : Status
    {
        public TransportationEnvironmentInfoStatus(bool state) : base(state)
        {
        }
        public List<TTransportationEnvironmentInfo> EnvironmentInfos { get; set; }

    }
}
