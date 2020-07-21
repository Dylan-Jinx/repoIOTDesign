using Microsoft.AspNetCore.Http;
using NutritiveMealSystem.TraceabilityServices.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace NutritiveMealSystem.FoodAnalysisServices.Models.FileModels
{
    public class CookBooKDTO:TCookBook
    {
        public  byte[] cookbookimg { get; set; }
    }
}
