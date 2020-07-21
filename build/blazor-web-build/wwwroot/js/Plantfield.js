function plantfieldCounta(valuearr, titlearr) {
    var myChart = echarts.init(document.querySelector(".plantfieldChart"));
    option = {
        backgroundColor: "#ffffff00",
        legend: {
            orient: 'vertical',
            top: "center",
            right: "5%",
            //data: ['rose1', 'rose2', 'rose3', 'rose4', 'rose5', 'rose6', 'rose7'],
            data: valuearr,
            textStyle: {
                color: "#fff",
                fontSize: 16
            }
        },
        tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b} : {c} ({d}%)'
        },
        series: [{
            name: '半径模式',
            type: 'pie',
            radius: ['30%', '80%'],
            center: ['40%', '50%'],
            roseType: 'radius',
            label: {
                show: true,
                normal: {
                    position: 'outside',
                    fontSize: 16
                }
            },
            labelLine: {
                length: 1,
                length2: 20,
                smooth: true
            },
            data: [{
                value: 1,
                name: titlearr[0],
                itemStyle: {
                    color: "rgba(50,123,250,0.7)",
                    borderColor: "rgba(50,123,250,1)",
                    borderWidth: 3
                }
            },
            {
                value: 2,
                name: titlearr[1],
                itemStyle: {
                    color: "rgba(244,201,7,0.7)",
                    borderColor: "rgba(244,201,7,1)",
                    borderWidth: 3
                }
            },
            {
                value: 3,
                name: titlearr[2],
                itemStyle: {
                    color: "rgba(23,216,161,0.7)",
                    borderColor: "rgba(23,216,161,1)",
                    borderWidth: 3
                }
            },
            {
                value: 4,
                name: titlearr[3],
                itemStyle: {
                    color: "rgba(122,60,235,0.7)",
                    borderColor: "rgba(122,60,235,1)",
                    borderWidth: 3
                }
            },
            {
                value: 5,
                name: titlearr[4],
                itemStyle: {
                    color: "rgba(15,197,243,0.7)",
                    borderColor: "rgba(15,197,243,1)",
                    borderWidth: 3
                }
            },
            {
                value: 6,
                name: titlearr[5],
                itemStyle: {
                    color: "rgba(15,197,243,0.7)",
                    borderColor: "rgba(15,197,243,1)",
                    borderWidth: 3
                }
            },
            {
                value: 7,
                name: titlearr[6],
                itemStyle: {
                    color: "rgba(15,197,243,0.7)",
                    borderColor: "rgba(15,197,243,1)",
                    borderWidth: 3
                }
            }
            ]
        }]
    };
    myChart.setOption(option);
}