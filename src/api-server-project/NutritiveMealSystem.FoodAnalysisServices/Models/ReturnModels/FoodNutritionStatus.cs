using NutritiveMealSystem.TraceabilityServices.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace NutritiveMealSystem.FoodAnalysisServices.Models.ReturnModels
{
    public class FoodNutritionStatus:Status
    {
        public List<TFoodNutrition> FoodNutritions { get; set; }
    }
}
