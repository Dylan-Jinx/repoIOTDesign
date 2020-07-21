using NutritiveMealSystem.FoodAnalysisServices.Models.ReturnModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace NutritiveMealSystem.FoodAnalysisServices.Models.FileModels
{
    public class FileStatus : Status
    {
        public string filename { get; set; }
    }
}
