using System;
using System.Collections.Generic;

namespace NutritiveMealSystem.TraceabilityServices.Models
{
    public partial class TFoodNutrition
    {
        public int Id { get; set; }
        public string FoodName { get; set; }
        public string NutritionalIngredient { get; set; }
        public string Introduce { get; set; }
        public string Images { get; set; }
    }
}
