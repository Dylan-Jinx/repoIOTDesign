using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace NutritiveMealSystem.TraceabilityServices.Models.ReturnModels
{
    public class PageStatus<T> : Status
    {
        public PageStatus(bool state) : base(state)
        {
        }
        public IQueryable<T> PageList { get; set; }
    }
}