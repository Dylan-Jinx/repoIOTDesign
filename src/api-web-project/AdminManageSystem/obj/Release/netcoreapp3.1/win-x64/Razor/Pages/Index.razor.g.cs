#pragma checksum "E:\Project\ProjectVer1.0\AdminMangeWebSourceProject\AdminManageWeb\AdminManageSystem\Pages\Index.razor" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "20fe6f0766a91a8959ad96f2f9a94bd17601e9df"
// <auto-generated/>
#pragma warning disable 1591
namespace AdminManageSystem.Pages
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Components;
#nullable restore
#line 1 "E:\Project\ProjectVer1.0\AdminMangeWebSourceProject\AdminManageWeb\AdminManageSystem\_Imports.razor"
using System.Net.Http;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "E:\Project\ProjectVer1.0\AdminMangeWebSourceProject\AdminManageWeb\AdminManageSystem\_Imports.razor"
using Microsoft.AspNetCore.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "E:\Project\ProjectVer1.0\AdminMangeWebSourceProject\AdminManageWeb\AdminManageSystem\_Imports.razor"
using Microsoft.AspNetCore.Components.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 4 "E:\Project\ProjectVer1.0\AdminMangeWebSourceProject\AdminManageWeb\AdminManageSystem\_Imports.razor"
using Microsoft.AspNetCore.Components.Forms;

#line default
#line hidden
#nullable disable
#nullable restore
#line 5 "E:\Project\ProjectVer1.0\AdminMangeWebSourceProject\AdminManageWeb\AdminManageSystem\_Imports.razor"
using Microsoft.AspNetCore.Components.Routing;

#line default
#line hidden
#nullable disable
#nullable restore
#line 6 "E:\Project\ProjectVer1.0\AdminMangeWebSourceProject\AdminManageWeb\AdminManageSystem\_Imports.razor"
using Microsoft.AspNetCore.Components.Web;

#line default
#line hidden
#nullable disable
#nullable restore
#line 8 "E:\Project\ProjectVer1.0\AdminMangeWebSourceProject\AdminManageWeb\AdminManageSystem\_Imports.razor"
using AdminManageSystem;

#line default
#line hidden
#nullable disable
#nullable restore
#line 9 "E:\Project\ProjectVer1.0\AdminMangeWebSourceProject\AdminManageWeb\AdminManageSystem\_Imports.razor"
using AdminManageSystem.Shared;

#line default
#line hidden
#nullable disable
#nullable restore
#line 10 "E:\Project\ProjectVer1.0\AdminMangeWebSourceProject\AdminManageWeb\AdminManageSystem\_Imports.razor"
using AntDesign;

#line default
#line hidden
#nullable disable
#nullable restore
#line 11 "E:\Project\ProjectVer1.0\AdminMangeWebSourceProject\AdminManageWeb\AdminManageSystem\_Imports.razor"
using System.ComponentModel;

#line default
#line hidden
#nullable disable
#nullable restore
#line 12 "E:\Project\ProjectVer1.0\AdminMangeWebSourceProject\AdminManageWeb\AdminManageSystem\_Imports.razor"
using AdminManageSystem.Utils;

#line default
#line hidden
#nullable disable
#nullable restore
#line 13 "E:\Project\ProjectVer1.0\AdminMangeWebSourceProject\AdminManageWeb\AdminManageSystem\_Imports.razor"
using AdminManageSystem.Data;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "E:\Project\ProjectVer1.0\AdminMangeWebSourceProject\AdminManageWeb\AdminManageSystem\Pages\Index.razor"
using Microsoft.JSInterop;

#line default
#line hidden
#nullable disable
    [Microsoft.AspNetCore.Components.RouteAttribute("/baseControl")]
    public partial class Index : Microsoft.AspNetCore.Components.ComponentBase, IDisposable
    {
        #pragma warning disable 1998
        protected override void BuildRenderTree(Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder)
        {
            __builder.OpenElement(0, "div");
            __builder.AddAttribute(1, "class", "bgx");
            __builder.AddMarkupContent(2, "\r\n\r\n    ");
            __builder.OpenElement(3, "header");
            __builder.AddMarkupContent(4, "\r\n        ");
            __builder.OpenElement(5, "h1");
            __builder.AddAttribute(6, "style", "font-size:40px;font-weight:bold;color:#fff;text-align: center;");
            __builder.AddMarkupContent(7, "基础管理信息可视化     -当前日期：");
            __builder.AddContent(8, 
#nullable restore
#line 12 "E:\Project\ProjectVer1.0\AdminMangeWebSourceProject\AdminManageWeb\AdminManageSystem\Pages\Index.razor"
                                                                                                          currentTime

#line default
#line hidden
#nullable disable
            );
            __builder.CloseElement();
            __builder.AddMarkupContent(9, "\r\n        <div class=\"showTime\"></div>\r\n    ");
            __builder.CloseElement();
            __builder.AddMarkupContent(10, "\r\n\r\n    \r\n    ");
            __builder.OpenElement(11, "section");
            __builder.AddAttribute(12, "class", "mainbox");
            __builder.AddMarkupContent(13, "\r\n        ");
            __builder.OpenElement(14, "div");
            __builder.AddAttribute(15, "class", "column");
            __builder.AddMarkupContent(16, "\r\n            ");
            __builder.AddMarkupContent(17, "<div class=\"panel bar\">\r\n                <h2></h2>\r\n                <div class=\"chart\" id=\"staffChart\"></div>\r\n                <div class=\"panel-footer\"></div>\r\n            </div>\r\n            ");
            __builder.OpenElement(18, "div");
            __builder.AddAttribute(19, "class", "panel line");
            __builder.AddMarkupContent(20, "\r\n                ");
            __builder.AddMarkupContent(21, "<h2>\r\n                </h2>\r\n                ");
            __builder.OpenElement(22, "div");
            __builder.AddAttribute(23, "class", "roundchart chart");
            __builder.AddElementReferenceCapture(24, (__value) => {
#nullable restore
#line 27 "E:\Project\ProjectVer1.0\AdminMangeWebSourceProject\AdminManageWeb\AdminManageSystem\Pages\Index.razor"
                           rounddivElement = __value;

#line default
#line hidden
#nullable disable
            }
            );
            __builder.CloseElement();
            __builder.AddMarkupContent(25, "\r\n                ");
            __builder.OpenElement(26, "div");
            __builder.AddAttribute(27, "class", "panel-footer");
            __builder.AddAttribute(28, "style", "float:left;text-align:center;");
            __builder.AddMarkupContent(29, "\r\n                    ");
            __builder.AddMarkupContent(30, "<label class=\"Rotation\" style=\"font-size:14px;font-weight:bold;color:#fff;\">食堂风扇：</label>\r\n                    ");
            __builder.OpenComponent<AntDesign.Switch>(31);
            __builder.AddAttribute(32, "Checked", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.Boolean>(
#nullable restore
#line 31 "E:\Project\ProjectVer1.0\AdminMangeWebSourceProject\AdminManageWeb\AdminManageSystem\Pages\Index.razor"
                                     false

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(33, "CheckedChildren", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<OneOf.OneOf<System.String, Microsoft.AspNetCore.Components.RenderFragment>>(
#nullable restore
#line 31 "E:\Project\ProjectVer1.0\AdminMangeWebSourceProject\AdminManageWeb\AdminManageSystem\Pages\Index.razor"
                                                               "开"

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(34, "UnCheckedChildren", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<OneOf.OneOf<System.String, Microsoft.AspNetCore.Components.RenderFragment>>(
#nullable restore
#line 31 "E:\Project\ProjectVer1.0\AdminMangeWebSourceProject\AdminManageWeb\AdminManageSystem\Pages\Index.razor"
                                                                                          "关"

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(35, "OnChange", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<Microsoft.AspNetCore.Components.EventCallback<System.Boolean>>(Microsoft.AspNetCore.Components.EventCallback.Factory.Create<System.Boolean>(this, 
#nullable restore
#line 31 "E:\Project\ProjectVer1.0\AdminMangeWebSourceProject\AdminManageWeb\AdminManageSystem\Pages\Index.razor"
                                                                                                          OpenFan

#line default
#line hidden
#nullable disable
            )));
            __builder.CloseComponent();
            __builder.AddMarkupContent(36, "\r\n                    <br>\r\n                ");
            __builder.CloseElement();
            __builder.AddMarkupContent(37, "\r\n            ");
            __builder.CloseElement();
            __builder.AddMarkupContent(38, "\r\n            ");
            __builder.OpenElement(39, "div");
            __builder.AddAttribute(40, "class", "panel pie");
            __builder.AddMarkupContent(41, "\r\n                ");
            __builder.AddMarkupContent(42, "<h2 style=\"font-weight:bold;font-size:24px\">今日配餐</h2>\r\n                ");
            __builder.OpenElement(43, "div");
            __builder.AddAttribute(44, "class", "chart");
            __builder.AddMarkupContent(45, "\r\n");
            __builder.AddContent(46, "                        ");
            __builder.OpenElement(47, "div");
            __builder.AddAttribute(48, "style", "float:left;text-align:center;margin-left:20px;margin-top:10px;");
            __builder.AddMarkupContent(49, "\r\n");
#nullable restore
#line 40 "E:\Project\ProjectVer1.0\AdminMangeWebSourceProject\AdminManageWeb\AdminManageSystem\Pages\Index.razor"
                             if (todayFoodPairList != null)
                            {

#line default
#line hidden
#nullable disable
            __builder.AddContent(50, "                                ");
            __builder.OpenElement(51, "div");
            __builder.AddAttribute(52, "style", "float:left");
            __builder.AddMarkupContent(53, "\r\n");
#nullable restore
#line 43 "E:\Project\ProjectVer1.0\AdminMangeWebSourceProject\AdminManageWeb\AdminManageSystem\Pages\Index.razor"
                                     for (int i = 0; i <= 4; i++)
                                    {

#line default
#line hidden
#nullable disable
            __builder.AddContent(54, "                                        ");
            __builder.OpenElement(55, "p");
            __builder.AddAttribute(56, "style", "color:#fff; font-weight:bold;font-size:14px");
            __builder.AddContent(57, 
#nullable restore
#line 45 "E:\Project\ProjectVer1.0\AdminMangeWebSourceProject\AdminManageWeb\AdminManageSystem\Pages\Index.razor"
                                                                                                todayFoodPairList[i].name

#line default
#line hidden
#nullable disable
            );
            __builder.CloseElement();
            __builder.AddMarkupContent(58, "\r\n");
#nullable restore
#line 46 "E:\Project\ProjectVer1.0\AdminMangeWebSourceProject\AdminManageWeb\AdminManageSystem\Pages\Index.razor"
                                    }

#line default
#line hidden
#nullable disable
            __builder.AddContent(59, "                                ");
            __builder.CloseElement();
            __builder.AddMarkupContent(60, "\r\n                                ");
            __builder.OpenElement(61, "div");
            __builder.AddAttribute(62, "style", "float:left;margin-left:10px");
            __builder.AddMarkupContent(63, "\r\n");
#nullable restore
#line 49 "E:\Project\ProjectVer1.0\AdminMangeWebSourceProject\AdminManageWeb\AdminManageSystem\Pages\Index.razor"
                                     for (int i = 5; i <= 9; i++)
                                    {

#line default
#line hidden
#nullable disable
            __builder.AddContent(64, "                                        ");
            __builder.OpenElement(65, "p");
            __builder.AddAttribute(66, "style", "color:#fff; font-weight:bold;font-size:14px");
            __builder.AddContent(67, 
#nullable restore
#line 51 "E:\Project\ProjectVer1.0\AdminMangeWebSourceProject\AdminManageWeb\AdminManageSystem\Pages\Index.razor"
                                                                                                todayFoodPairList[i].name

#line default
#line hidden
#nullable disable
            );
            __builder.CloseElement();
            __builder.AddMarkupContent(68, "\r\n");
#nullable restore
#line 52 "E:\Project\ProjectVer1.0\AdminMangeWebSourceProject\AdminManageWeb\AdminManageSystem\Pages\Index.razor"
                                    }

#line default
#line hidden
#nullable disable
            __builder.AddContent(69, "                                ");
            __builder.CloseElement();
            __builder.AddMarkupContent(70, "\r\n");
            __builder.AddContent(71, "                                ");
            __builder.OpenElement(72, "div");
            __builder.AddAttribute(73, "style", "float:left;margin-left:20px");
            __builder.AddMarkupContent(74, "\r\n");
#nullable restore
#line 56 "E:\Project\ProjectVer1.0\AdminMangeWebSourceProject\AdminManageWeb\AdminManageSystem\Pages\Index.razor"
                                     for (int i = 10; i <= 14; i++)
                                    {

#line default
#line hidden
#nullable disable
            __builder.AddContent(75, "                                        ");
            __builder.OpenElement(76, "p");
            __builder.AddAttribute(77, "style", "color:#fff; font-weight:bold;font-size:14px");
            __builder.AddContent(78, 
#nullable restore
#line 58 "E:\Project\ProjectVer1.0\AdminMangeWebSourceProject\AdminManageWeb\AdminManageSystem\Pages\Index.razor"
                                                                                                todayFoodPairList[i].name

#line default
#line hidden
#nullable disable
            );
            __builder.CloseElement();
            __builder.AddMarkupContent(79, "\r\n");
#nullable restore
#line 59 "E:\Project\ProjectVer1.0\AdminMangeWebSourceProject\AdminManageWeb\AdminManageSystem\Pages\Index.razor"
                                    }

#line default
#line hidden
#nullable disable
            __builder.AddContent(80, "                                ");
            __builder.CloseElement();
            __builder.AddMarkupContent(81, "\r\n");
#nullable restore
#line 61 "E:\Project\ProjectVer1.0\AdminMangeWebSourceProject\AdminManageWeb\AdminManageSystem\Pages\Index.razor"
                            }

#line default
#line hidden
#nullable disable
            __builder.AddContent(82, "                        ");
            __builder.CloseElement();
            __builder.AddMarkupContent(83, "\r\n");
            __builder.AddContent(84, "                ");
            __builder.CloseElement();
            __builder.AddMarkupContent(85, "\r\n                <div class=\"panel-footer\"></div>\r\n            ");
            __builder.CloseElement();
            __builder.AddMarkupContent(86, "\r\n        ");
            __builder.CloseElement();
            __builder.AddMarkupContent(87, "\r\n        ");
            __builder.OpenElement(88, "div");
            __builder.AddAttribute(89, "class", "column");
            __builder.AddMarkupContent(90, "\r\n            \r\n            ");
            __builder.OpenElement(91, "div");
            __builder.AddAttribute(92, "class", "no");
            __builder.AddMarkupContent(93, "\r\n                ");
            __builder.OpenElement(94, "div");
            __builder.AddAttribute(95, "class", "no-hd");
            __builder.AddMarkupContent(96, "\r\n                    ");
            __builder.OpenElement(97, "ul");
            __builder.AddMarkupContent(98, "\r\n                        ");
            __builder.OpenElement(99, "li");
            __builder.AddContent(100, 
#nullable restore
#line 74 "E:\Project\ProjectVer1.0\AdminMangeWebSourceProject\AdminManageWeb\AdminManageSystem\Pages\Index.razor"
                             fifthMonthSum

#line default
#line hidden
#nullable disable
            );
            __builder.CloseElement();
            __builder.AddMarkupContent(101, "\r\n                        ");
            __builder.AddMarkupContent(102, "<li>100000</li>\r\n                    ");
            __builder.CloseElement();
            __builder.AddMarkupContent(103, "\r\n                ");
            __builder.CloseElement();
            __builder.AddMarkupContent(104, "\r\n                ");
            __builder.AddMarkupContent(105, "<div class=\"no-bd\">\r\n                    <ul>\r\n                        <li>本月账单总额</li>\r\n                        <li>市场供应人数</li>\r\n                    </ul>\r\n                </div>\r\n            ");
            __builder.CloseElement();
            __builder.AddMarkupContent(106, "\r\n            \r\n            ");
            __builder.AddMarkupContent(107, @"<div class=""map"">
                <h2 style=""font-size:28px;font-weight:bold;color:#fff;text-align: center;"">食材运输模拟示意图</h2>
                <div class=""map1""></div>
                <div class=""map2""></div>
                <div class=""map3""></div>
                <div class=""chart""></div>
            </div>
        ");
            __builder.CloseElement();
            __builder.AddMarkupContent(108, "\r\n        ");
            __builder.AddMarkupContent(109, @"<div class=""column"">
            <div class=""panel bar2"">
                <h2 style=""font-weight:bold"">种植基地水质检测实时汇总</h2>
                <div class=""chart waterqualityChart""></div>
                <div class=""panel-footer""></div>
            </div>
            <div class=""panel line2"">
                <h2></h2>
                <div class=""chart billchart""></div>
                <div class=""panel-footer""></div>
            </div>
            <div class=""panel pie2"">
                <h2 style=""font-weight:bold"">食材种植地区分布</h2>

                <div class=""chart plantfieldChart""></div>
                <div class=""panel-footer""></div>
            </div>
        </div>
    ");
            __builder.CloseElement();
            __builder.AddMarkupContent(110, "\r\n\r\n");
            __builder.CloseElement();
        }
        #pragma warning restore 1998
#nullable restore
#line 117 "E:\Project\ProjectVer1.0\AdminMangeWebSourceProject\AdminManageWeb\AdminManageSystem\Pages\Index.razor"
      
    private ElementReference chartdivElement;
    private ElementReference rounddivElement;


    public int[] temphumi = new int[2];
    public object[] parmasObject;
    public string dataJsonString;
    Random temphumiRandom = new Random();
    Random waterqualityRandom = new Random();
    /// <summary>
    /// 配餐数量
    /// </summary>
    private int _foodPairCount=15;

    private List<data> datas;
    /// <summary>
    /// 当前时间获取
    /// </summary>
    public string currentTime { get; set; }

    //水质分析收集
    private int[] waterquality=new int[3];

    System.Threading.Thread temphumiThread;
    System.Threading.Thread waterqualityThread;

    string zzy = "漳州职业技术学院";
    string fzy = "福州职业技术学院";
    string xhzy = "厦门海洋职业技术学院";


    class data
    {
        public string name { get; set; }
        public int value { get; set; }
    }

    protected override Task OnParametersSetAsync()
    {
        new System.Threading.Thread(getCurrentTime).Start();
        getFiveMonthBill();
        getStaffCount();
        getTodayFoodPairing();
        RetrospectDatasInit();
        return base.OnParametersSetAsync();
    }

    protected override async Task OnAfterRenderAsync(bool firstRender)
    {

        await JSRuntime.InvokeVoidAsync("flexible", null);
        if (firstRender)
        {
            await JSRuntime.InvokeVoidAsync("removeflexible", null);
            await JSRuntime.InvokeVoidAsync("startSystem", null);
            //await JSRuntime.InvokeVoidAsync("startTempHumiListener", temphumi);
            await JSRuntime.InvokeVoidAsync("staffstartxx", datas);
            await JSRuntime.InvokeVoidAsync("billStart", monthSumArrayDTO);
            await JSRuntime.InvokeVoidAsync("plantfieldCounta", typeCountList, typeLists);
            //await JSRuntime.InvokeVoidAsync("waterqualityStart", waterquality);
            temphumiThread = new System.Threading.Thread(RandomHumiTemp);
            waterqualityThread = new System.Threading.Thread(getwaterqualityRandom);
            temphumiThread.Start();
            waterqualityThread.Start();

        }

    }

    private void getCurrentTime()
    {
        while (true)
        {
            currentTime = DateTime.Now.ToString("yyyy-MM-dd");
        }
    }

    #region——五个月账单数据的操作——
    //获得总账单和分割成三个月账单的集合
    private List<Bill> sumBillLists;

    private List<Bill> firstMonthLists;
    private List<Bill> secondMonthLists;
    private List<Bill> thirdMonthLists;
    private List<Bill> fourthMonthLists;
    private List<Bill> fifthMonthLists;

    //计算账单开销总数
    List<int> sumFirstMonthArr = new List<int>();
    List<int> sumSecondMonthArr = new List<int>();
    List<int> sumThirdMonthArr = new List<int>();
    List<int> sumFourthMonthArr = new List<int>();
    List<int> sumFifthMonthArr = new List<int>();

    int firstMonthSum;
    int secondMonthSum;
    int thirdMonthSum;
    int fourthMonthSum;
    int fifthMonthSum;

    List<int> monthSumArrayDTO = new List<int>();
    /// <summary>
    /// 获得五个月的账单总额  启动账单图表数据
    /// </summary>
    private void getFiveMonthBill()
    {
        getFiveEveryMonthBill();

        getStorageBillList();

        calcSumDTO();
    }

    /// <summary>
    /// 获得存储账单集合
    /// </summary>
    private void getStorageBillList()
    {
        traverseListDatas(firstMonthLists, sumFirstMonthArr);
        traverseListDatas(secondMonthLists, sumSecondMonthArr);
        traverseListDatas(thirdMonthLists, sumThirdMonthArr);
        traverseListDatas(fourthMonthLists, sumFourthMonthArr);
        traverseListDatas(fifthMonthLists, sumFifthMonthArr);
    }

    /// <summary>
    /// 分类出前五个月每个月账单对象
    /// </summary>
    private void getFiveEveryMonthBill()
    {
        int getDay = DateTime.Now.Day;
        DateTime currentDateTime = DateTime.Now.AddDays(-getDay + 1);//7
        DateTime addfirstDateTime = currentDateTime.AddMonths(1);//8
        DateTime exfirstDateTime = currentDateTime.AddMonths(-1);//6
        DateTime exsecondDateTime = currentDateTime.AddMonths(-2);//5
        DateTime exthirdDateTime = currentDateTime.AddMonths(-3);//4
        DateTime exfourthDateTime = currentDateTime.AddMonths(-4);//3
        PlatformSDKApi api = new PlatformSDKApi("", ServicesType.SchoolCookHouseServices);
        sumBillLists = api.GetAllCookHouseBill().bill;
        firstMonthLists = sumBillLists.Where(a => a.billDatetime > exfourthDateTime && a.billDatetime < exthirdDateTime).ToList();
        secondMonthLists = sumBillLists.Where(a => a.billDatetime > exthirdDateTime && a.billDatetime < exsecondDateTime).ToList();
        thirdMonthLists = sumBillLists.Where(a => a.billDatetime > exsecondDateTime && a.billDatetime < exfirstDateTime).ToList();
        fourthMonthLists = sumBillLists.Where(a => a.billDatetime > exfirstDateTime && a.billDatetime < currentDateTime).ToList();
        fifthMonthLists = sumBillLists.Where(a => a.billDatetime > currentDateTime && a.billDatetime < addfirstDateTime).ToList();
    }
    /// <summary>
    /// 整理为数据传输对象传输给图表
    /// </summary>
    private void calcSumDTO()
    {
        firstMonthSum = calcPriceSum(sumFirstMonthArr);
        secondMonthSum = calcPriceSum(sumSecondMonthArr);
        thirdMonthSum = calcPriceSum(sumThirdMonthArr);
        fourthMonthSum = calcPriceSum(sumFourthMonthArr);
        fifthMonthSum = calcPriceSum(sumFifthMonthArr);
        monthSumArrayDTO.Add(firstMonthSum);
        monthSumArrayDTO.Add(secondMonthSum);
        monthSumArrayDTO.Add(thirdMonthSum);
        monthSumArrayDTO.Add(fourthMonthSum);
        monthSumArrayDTO.Add(fifthMonthSum);
    }

    /// <summary>
    /// 存储账单集合
    /// </summary>
    /// <param name="lists"></param>
    /// <param name="buffData"></param>
    private void traverseListDatas(List<Bill> lists, List<int> buffData)
    {
        foreach (var temp in lists)
        {
            buffData.Add(temp.price);
        }
    }

    /// <summary>
    /// 计算每个月的账单总额
    /// </summary>
    /// <param name="priceDatas"></param>
    /// <param name="priceSum"></param>
    private int calcPriceSum(List<int> priceDatas)
    {
        int sum = 0;
        foreach (var temp in priceDatas)
        {
            sum += temp;
        }
        return sum;
    }
    #endregion

    #region——计算员工总和——


    void getStaffCount()
    {
        PlatformSDKApi api = new PlatformSDKApi("", ServicesType.SchoolCookHouseServices);
        List<Staff> staffLists = api.GetCookHouseStaff().staff;
        int z1 = staffLists.Where(a => a.position.Contains(zzy)).Count();
        int z2 = staffLists.Where(a => a.position.Contains(fzy)).Count();
        int z3 = staffLists.Where(a => a.position.Contains(xhzy)).Count();

        datas = new List<data>()
{
            new data(){name=zzy,value=z1},
            new data(){name=fzy,value=z2},
            new data(){name=xhzy,value=z3}
        };
    }
    #endregion

    #region——今日配餐——

    private List<CookBooks> saveAllFoodPairs;
    private List<CookBooks> todayFoodPairList = new List<CookBooks>();
    /// <summary>
    /// 所有配餐数据存储本地
    /// </summary>
    private void getTodayFoodPairing()
    {
        PlatformSDKApi api = new PlatformSDKApi("", ServicesType.FoodAnalysisServices);
        saveAllFoodPairs = api.GetAllCookBooks().cookBooks;
        RandomFoodPair(saveAllFoodPairs.Count);
    }
    /// <summary>
    /// 生成今日配餐
    /// </summary>
    /// <param name="allcount"></param>
    private void RandomFoodPair(int allcount)
    {
        Random random = new Random();
        for (int i = 0; i <= _foodPairCount; i++)
        {
            int id = random.Next(1, allcount);
            CookBooks query = saveAllFoodPairs[i];
            todayFoodPairList.Add(query);
        }
    }

    #endregion

    #region——追溯信息操作——
    /// <summary>
    /// 种植信息
    /// </summary>
    List<PlantInfos> plantInfos;
    /// <summary>
    /// 运输环境信息
    /// </summary>
    List<EnvironmentInfos> environmentInfos;
    /// <summary>
    /// 仓库信息
    /// </summary>
    List<Warehouses> wareHouses;
    /// <summary>
    /// 水质检测信息
    /// </summary>
    List<WaterQualityInfos> waterQualityInfos;
    /// <summary>
    /// 产品批次信息
    /// </summary>
    List<Products> products;
    /// <summary>
    /// 产品基地信息
    /// </summary>
    List<ProductionBaseInfos> productionBaseInfos;

    List<int> typeCountList;
    List<string> typeLists;


    /// <summary>
    /// 追溯信息初始化
    /// </summary>
    private void RetrospectDatasInit()
    {
        PlatformSDKApi api = new PlatformSDKApi("", ServicesType.TraceabilityServices);
        plantInfos = api.GetAllPlantInfo().plantInfos;
        environmentInfos = api.GetAllTransferEnvironInfo().environmentInfos;
        wareHouses = api.GetAllWareHouseInfo().warehouses;
        waterQualityInfos = api.GetAllWaterQualityInfo().waterQualityInfos;
        products = api.GetAllProductNumInfo().products;
        productionBaseInfos = api.GetAllPlantBaseInfo().productionBaseInfos;


        typeCountList =  TypePlantField();
    }
    /// <summary>
    /// 种植地区分类并获得种植地分类数值
    /// </summary>
    /// <returns></returns>
    private List<int> TypePlantField()
    {
        string exString = string.Empty;
        List<int> countLists = new List<int>();
        typeLists = new List<string>();
        foreach(var temp in plantInfos)
        {
            if (temp.plantFieldNum.ToString().Substring(0, 2) != exString)
            {
                typeLists.Add(temp.plantFieldNum.ToString().Substring(0, 2));
                exString = temp.plantFieldNum.ToString().Substring(0, 2);
            }
        }
        if (typeLists != null)
        {
            foreach(var temp in typeLists)
            {
                countLists.Add(plantInfos.Where(a => a.plantFieldNum.Contains(temp)).Count());
            }
        }
        return countLists;
    }
    #endregion

    protected override Task OnInitializedAsync()
    {
        NavigationManager.LocationChanged += HandleLocationChanged;
        return base.OnInitializedAsync();
    }

    private void HandleLocationChanged(object sender, LocationChangedEventArgs e)
    {
        JSRuntime.InvokeVoidAsync("removeflexible", null);
        humiflag = false;
        getwaterflag = false;
    }

    public bool flag = true;
    public void Dispose()
    {
        JSRuntime.InvokeVoidAsync("loadLib", null);
        // NavigationManager.LocationChanged -= HandleLocationChanged;

    }

    bool humiflag=true;
    bool getwaterflag=true;
    public void RandomHumiTemp()
    {
        while (true)
        {
            if (humiflag)
            {
                temphumi[0] = temphumiRandom.Next(24, 38);
                temphumi[1] = temphumiRandom.Next(40, 80);
                JSRuntime.InvokeVoidAsync("startTempHumiListener", temphumi);
                System.Threading.Thread.Sleep(3000);
            }
            else
            {
                break;
            }
        }
    }

    private void getwaterqualityRandom()
    {
        while (true)
        {
            if (getwaterflag)
            {
                waterquality[0] = waterqualityRandom.Next(4, 6);
                waterquality[1] = waterqualityRandom.Next(22, 30);
                waterquality[2] = waterqualityRandom.Next(2, 8);
                JSRuntime.InvokeVoidAsync("waterqualityStart", waterquality);
                System.Threading.Thread.Sleep(5000);
            }
            else
            {
                break;
            }
        }
    }
    public int checking { get; set; }
    //操控设备
    public async void OpenFan()
    {
        checking++;
        if (checking%2!=0)
        {
            Nlecloud nlecloud = new Nlecloud();
            AccountDTO accountDTO = new AccountDTO()
            {
                Account = "13850526746",
                Password = "a8629327",
                IsRememberMe = true
            };
            string accesstoken = nlecloud.UserLogin(accountDTO);
            CmdsDTO x = nlecloud.ControlDevices(accesstoken, "104912", "on_off",1);
        }
        else
        {
            Nlecloud nlecloud = new Nlecloud();
            AccountDTO accountDTO = new AccountDTO()
            {
                Account = "13850526746",
                Password = "a8629327",
                IsRememberMe = true
            };
            string accesstoken = nlecloud.UserLogin(accountDTO);
            CmdsDTO x = nlecloud.ControlDevices(accesstoken, "104912", "on_off",0);
        }
    }


#line default
#line hidden
#nullable disable
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private IJSRuntime JSRuntime { get; set; }
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private NavigationManager NavigationManager { get; set; }
    }
}
#pragma warning restore 1591
