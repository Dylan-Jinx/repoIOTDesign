function waterqualityStart(arr) {
    var myChart = echarts.init(document.querySelector(".waterqualityChart"));
	//	得到仪表盘
	let axisLine = {
		show: false,
		lineStyle: {
			width: 10,
			shadowBlur: 0,
			color: [
				[0.2, '#6ff2c2'],
				[0.4, '#c2fb83'],
				[0.6, '#eadc57'],
				[0.8, '#fab272'],
				[1, '#ff776b']
			]
		}
	}
	let textStyle = {
		fontWeight: 'normal',
		fontSize: 16,
		color: "#fff"
	}
	let axisLineZhou = { // 坐标轴线  
		lineStyle: {
			color: [
				[0.66, '#dddddd'],
				[1, '#dddddd']
			], // 属性lineStyle控制线条样式  
			width: 2
		}
	}
	//仪表盘刻度
	let axisTicks = {
		show: true,
		lineStyle: {
			color: '#1b8586',
			width: 1
		},
		length: -5,
		splitNumber: 8
	}
	let splitLines = {
		show: true,
		length: -10,
		lineStyle: {
			color: '#1b8586',
		}
	}
	let zuoBiaoAxisLabel = {
		distance: -15,
		textStyle: {
			color: "#03B7C9",
			fontSize: "8"
		}
	}
	let details = { //表盘的数据,字体颜色也在这里进行修改
		show: true,
		offsetCenter: [0, '90%'],
		textStyle: {
			fontSize: 18,
			color: "#ff7705",
			padding: [20, 0, 0, 0]
		}
	}
	let Heightdetails = { //表盘的数据,字体颜色也在这里进行修改,高危部分的修改
		show: true,
		offsetCenter: [0, '90%'],
		textStyle: {
			fontSize: 18,
			color: "#ff7705",
		}
	}
	var myRate1 = 100;
	option = {
		title: [{
			x: "12%",
			bottom: '10%',
			text: 'PH',
			textStyle: textStyle,
		}, {
			x: "37%",
			bottom: '10%',
			text: '温度',
			textStyle: textStyle,
		}, {
			x: "61%",
			bottom: '10%',
			text: '浊度',
			textStyle: textStyle,
		}],
		backgroundColor: "#ffffff00",
		series: [{ //高危攻击
			type: 'gauge',
			center: ['50%', '50%'], // 默认全局居中  
			radius: '38%',
			splitNumber: 8, //刻度数量
			min: 0,
			max: 50,
			startAngle: 200,
			endAngle: -20,
			clockwise: true,
			axisLine: {
				show: true,
				lineStyle: {
					width: 2,
					shadowBlur: 0,
					color: [
						[1, '#1b8586']
					]
				}
			},
			axisTick: axisTicks,
			splitLine: splitLines,
			axisLabel: zuoBiaoAxisLabel,
			pointer: { //仪表盘指针
				show: 0
			},
			detail: {
				show: false
			},
			data: [{
				name: "",
				value: myRate1
			}]
		}, { //高危攻击
			startAngle: 200,
			endAngle: -20,
			type: 'gauge',
			center: ['50%', '50%'], // 默认全局居中  
			radius: '31%',
			min: 0,
			max: 10,
			splitNumber: 0,
			axisLine: axisLineZhou, // 坐标轴线  ,
			axisLabel: { // 坐标轴小标记  
				show: false,
			},
			splitLine: { // 分隔线  
				length: 10, // 属性length控制线长  
				lineStyle: { // 属性lineStyle（详见lineStyle）控制线条样式  
					width: 0,
					color: '#444'
				}
			},
			pointer: { // 分隔线 指针  
				color: '#666666',
				width: 0,
				length: 230
			},
			detail: {
				show: false
			},
		}, { //高危攻击
			type: 'gauge',
			startAngle: 200,
			endAngle: -20,
			radius: '25%',
			center: ['50%', '50%'], // 默认全局居中  
			min: 0,
			max: 10,
			axisLine: axisLine,
			axisTick: {
				show: false
			},
			splitLine: {
				show: false,
				length: 20,
			},
			axisLabel: {
				show: false
			},
			pointer: {
				show: true,
			},
			detail: Heightdetails,
			itemStyle: {
				normal: {
					color: "#09c2c0",
				}
			},
			data: [{
				value: arr[1]
				//温度
			}]
		}, {
			type: 'gauge',
			center: ['25%', '50%'], // 默认全局居中  
			radius: '35%',
			splitNumber: 8, //刻度数量
			min: 0,
			max: 1000,
			endAngle: 45,
			clockwise: true,
			axisLine: {
				show: true,
				lineStyle: {
					width: 2,
					shadowBlur: 0,
					color: [
						[1, '#1b8586']
					]
				}
			},
			axisTick: axisTicks,
			splitLine: splitLines,
			axisLabel: zuoBiaoAxisLabel,
			pointer: { //仪表盘指针
				show: 0
			},
			detail: {
				show: false,
				textStyle: { // 其余属性默认使用全局文本样式，详见TEXTSTYLE
					color: '#f00',
					fontSize: 14
				},
			},
			data: [{
				name: "",
				value: myRate1
			}]
		}, {
			type: 'gauge',
			center: ['25%', '50%'], // 默认全局居中  
			radius: '30%',
			min: 0,
			max: 1000,
			endAngle: 45,
			splitNumber: 0,
			axisLine: axisLineZhou, // 坐标轴线  ,
			axisLabel: { // 坐标轴小标记  
				show: false
			},
			splitLine: { // 分隔线  
				length: 10, // 属性length控制线长  
				lineStyle: { // 属性lineStyle（详见lineStyle）控制线条样式  
					width: 0,
					color: '#444'
				}
			},
			pointer: { // 分隔线 指针  
				color: '#666666',
				width: 0,
				length: 230
			},
			detail: {
				show: false
			},
		}, {
			name: '中危攻击',
			type: 'gauge',
			endAngle: 45,
			radius: '25%',
			center: ['25%', '50%'], // 默认全局居中  
			min: 0,
			max: 10,
			axisLine: axisLine,
			axisTick: {
				show: false,
			},
			splitLine: {
				show: false,
				length: 20,
			},

			axisLabel: {
				show: false
			},
			pointer: {
				show: true,
				width: 5
			},
			detail: details,
			itemStyle: {
				normal: {
					color: "#09c2c0",
				}
			},
			data: [{
				value: arr[0]
				//ph数值
			}]
		}, {
			type: 'gauge',
			center: ['73%', '50%'], // 默认全局居中  
			radius: '35%',
			splitNumber: 8, //刻度数量
			min: 0,
			max: 1000,
			startAngle: 140,
			endAngle: -45,
			clockwise: true,
			axisLine: {
				show: true,
				lineStyle: {
					width: 2,
					shadowBlur: 0,
					color: [
						[1, '#1b8586']
					]
				}
			},
			axisTick: axisTicks,
			splitLine: splitLines,
			axisLabel: zuoBiaoAxisLabel,
			pointer: { //仪表盘指针
				show: 0
			},
			detail: {
				show: false
			},
			data: [{
				name: "",
				value: myRate1
			}]
		}, {
			type: 'gauge',
			center: ['73%', '50%'], // 默认全局居中  
			radius: '30%',
			min: 0,
			max: 1000,
			startAngle: 140,
			endAngle: -45,
			splitNumber: 0,
			axisLine: axisLineZhou, // 坐标轴线  ,
			axisLabel: { // 坐标轴小标记  
				show: false,
			},
			splitLine: { // 分隔线  
				show: false,
			},
			pointer: { // 分隔线 指针  
				color: '#666666',
				width: 0,
				length: 230
			},
			detail: {
				show: false
			},
		}, {
			name: '低危攻击',
			type: 'gauge',
			startAngle: 140,
			endAngle: -45,
			radius: '25%',
			center: ['73%', '50%'], // 默认全局居中  
			min: 0,
			max: 10,
			axisLine: axisLine,
			axisTick: {
				show: false
			},
			splitLine: {
				show: false,
				length: 20,

			},
			axisLabel: {
				show: false
			},
			pointer: {
				show: true,
				width: 5
			},
			detail: details,
			itemStyle: {
				normal: {
					color: "#09c2c0",
				}
			},
			data: [{
				value: arr[2]
				//浊度
			}]
		}]
	};

    myChart.setOption(option);
}