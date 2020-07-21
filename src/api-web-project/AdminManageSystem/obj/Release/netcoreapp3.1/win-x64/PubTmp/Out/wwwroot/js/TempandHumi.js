function startTempHumiListener(arr) {
    var highlight = '#03b7c9';

    var myChart = echarts.init(document.querySelector(".roundchart"));

    var demoData = [{
        name: '温度',
        value: arr[0],
        unit: '℃',
        pos: ['25%', '40%'],
        range: [0, 40],
        YS: [
            [0.57, '#119eff'],
            [0.8, '#30da74'],
            [1, '#f3390d']
        ]
    },
    {
        name: '湿度',
        value: arr[1],
        unit: '%',
        pos: ['75%', '40%'],
        range: [0, 100],
        splitNum: 10,
        YS: [
            [0.3, '#f3390d'],
            [0.8, '#30da74'],
            [1, '#119eff']
        ]
    }
    ];

    option = {
        backgroundColor: '#ffffff00',
        title: {
            text: '食堂实时温湿度检测- ',
            textStyle: {
                align: 'center',
                color: '#fff',
                fontSize: 16,
            },
            top: '0%',
            left: 'center',
        },
      series: (function() {
          var result = [];

          demoData.forEach(function(item) {
              result.push(
                  // 外围刻度
                  {
                      type: 'gauge',
                      center: item.pos,
                      radius: '50%', // 1行2个
                      splitNumber: item.splitNum || 10,
                      min: item.range[0],
                      max: item.range[1],
                      startAngle: 225,
                      endAngle: -45,
                      axisLine: {
                          show: true,
                          lineStyle: {
                              width: 2,
                              shadowBlur: 0,
                              color: [
                                  [1, highlight]
                              ]
                          }
                      },
                      axisTick: {
                          show: true,
                          lineStyle: {
                              color: highlight,
                              width: 1
                          },
                          length: -5,
                          splitNumber: 10
                      },
                      splitLine: {
                          show: true,
                          length: -10,
                          lineStyle: {
                              color: highlight,
                          }
                      },
                      axisLabel: {
                          distance: -18,
                          textStyle: {
                              color: highlight,
                              fontSize: '10',

                          }
                      },
                      pointer: {
                          show: 0
                      },
                      detail: {
                          show: 0
                      }
                  }, {
                      name: '速度',
                      type: 'gauge',
                      center: item.pos,
                      splitNumber: item.splitNum || 10,
                      min: item.range[0],
                      max: item.range[1],
                      radius: '45%',
                      axisLine: { // 坐标轴线
                          show: false,
                          lineStyle: { // 属性lineStyle控制线条样式
                              color: item.YS,
                              shadowColor: "#ccc",
                              shadowBlur: 25,
                              width: 0
                          }
                      },
                      axisLabel: {
                          show: false
                      },
                      axisTick: { // 坐标轴小标记
                          // show: false,
                          length: 20, // 属性length控制线长
                          lineStyle: { // 属性lineStyle控制线条样式
                              color: 'auto',
                              width: 2
                          }
                      },
                      splitLine: { // 分隔线
                          show: false,
                          length: 20, // 属性length控制线长
                          lineStyle: { // 属性lineStyle（详见lineStyle）控制线条样式
                              color: 'auto'
                          }
                      },
                      title: {
                          textStyle: { // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                              fontWeight: 'bolder',
                              fontSize: 20,
                              fontStyle: 'italic'
                          }
                      },
                      detail: {
                          show: true,
                          offsetCenter: [0, '100%'],
                          textStyle: {
                              fontSize: 25
                          },
                          formatter: [
                              '{value} ' + (item.unit || ''),
                              '{name|' + item.name + '}'
                          ].join('\n'),
                          rich: {
                              name: {
                                  fontSize: 16,
                                  lineHeight: 30,
                                  color: '#4be4de'
                              }
                          }
                      },
                      data: [{
                          value: item.value
                      }],
                      pointer: {
                          width: 5
                      }
                  },
                  // 内侧指针、数值显示
                  {
                      name: item.name,
                      type: 'gauge',
                      center: item.pos,
                      radius: '40%',
                      startAngle: 225,
                      endAngle: -45,
                      min: item.range[0],
                      max: item.range[1],
                      axisLine: {
                          show: true,
                          lineStyle: {
                              width: 16,
                              color: [
                                  [1, 'rgba(75,228,255,.1)']
                              ]
                          }
                      },
                      axisTick: {
                          show: 0,
                      },
                      splitLine: {
                          show: 0,
                      },
                      axisLabel: {
                          show: 0
                      },
                      pointer: {
                          show: true,
                          length: '90%',
                          width: 3,
                      },
                      itemStyle: { //表盘指针的颜色
                          color: 'rgba(255, 153, 0, 0.31)',
                          borderColor: '#ff9900',
                          borderWidth: 1
                      },
                      detail: {
                          show: false,
                          offsetCenter: [0, '100%'],
                          textStyle: {
                              fontSize: 20,
                              color: '#00eff2'
                          },
                          formatter: [
                              '{value} ' + (item.unit || ''),
                              '{name|' + item.name + '}'
                          ].join('\n'),
                          rich: {
                              name: {
                                  fontSize: 14,
                                  lineHeight: 30,
                                  color: '#00eff2'
                              }
                          }
                      },

                      data: [{
                          value: item.value
                      }]
                  }
              );
          });
          return result;
      })()
  };

    myChart.setOption(option);
}