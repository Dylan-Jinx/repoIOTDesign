using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AdminManageSystem.Utils
{
    public class TraceableApiUrl
    {
        /// <summary>
        /// /api/PlantInfo/GetAllPlantInfo 获得所有种植信息表
        /// </summary>
        public static string getallplantinfo = "/api/PlantInfo/GetAllPlantInfo";
        /// <summary>
        /// /api/ProductionBaseInfo/GetAllProductionBaseInfo 获得所有种植基地信息
        /// </summary>
        public static string getallplantbaseinfo = "/api/ProductionBaseInfo/GetAllProductionBaseInfo";
        /// <summary>
        /// /api/ProductNumInfo/GetAllProductInfo 获得所有产品批次信息
        /// </summary>
        public static string getallproductnuminfo = "/api/ProductNumInfo/GetAllProductInfo";
        /// <summary>
        /// /api/TransportationEnvironmentInfo/GetAllEnvironmentInfo 获得运输环境的信息
        /// </summary>
        public static string getalltransferenvironinfo = "/api/TransportationEnvironmentInfo/GetAllEnvironmentInfo";
        /// <summary>
        /// /api/WarehouseInfo/GetWareHouseInfo 获得所有仓库的信息
        /// </summary>
        public static string getallwarehouseinfo = "/api/WarehouseInfo/GetWareHouseInfo";
        /// <summary>
        /// /api/WaterQuality/GetAllWaterQualityInfo 获得所有水质信息
        /// </summary>
        public static string getallwaterqualityinfo = "/api/WaterQuality/GetAllWaterQualityInfo";
    }
}
