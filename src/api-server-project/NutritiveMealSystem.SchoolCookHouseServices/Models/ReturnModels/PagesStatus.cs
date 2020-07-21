using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace NutritiveMealSystem.SchoolCookHouseServices.Models.ReturnModels
{
    public class PagesStatus<T>:Status
    {
        public IQueryable<T> PageList { get; set; }
    }
}
