
'use strict';

doFetchCourseRegistrations()
	.then(function(response) {

		// initialize the echarts instance based on the prepared dom
		var myChart = echarts.init(document.getElementById('main'));

		// specify the configuration items and data for the chart
		var option = {
			title: {
				text: '',
				subtext: '',
				left: 'center'
			},
			tooltip: {
				trigger: 'item'
			},
			legend: {
				orient: 'vertical',
				left: 'left'
			},
			series: [
				{
					name: 'Access From',
					type: 'pie',
					radius: '50%',
					data: [],
					emphasis: {
						itemStyle: {
							shadowBlur: 10,
							shadowOffsetX: 0,
							shadowColor: 'rgba(0, 0, 0, 0.5)'
						}
					}
				}
			]
		};

		//assembling data to be populated
		const data = [];
		let counter = 0;
		for (let course of response.registrations) {
			const courseData = new Object();
			courseData.value = course.totalRegistrations;
			courseData.name = course.courseCode;
			data[counter] = courseData;
			counter++;
		}

		//populating data on chart
		option.series[0].data = data;

		// display the chart using the configuration items and data just specified.
		myChart.setOption(option);

	})
	.catch(function() {
		console.log('error!');
	});

//for fetching course data for the pie-chart
function doFetchCourseRegistrations() {

	return new Promise(function(resolve, reject) {
		const request = new XMLHttpRequest();
		//callback
		request.onload = function() {
			if (request.status == 200) {
				var response = JSON.parse(request.responseText);
				resolve(response);
			} else {
				console.log('data retrieval failed!');
			}
		}
		request.open("GET", "http://localhost:8080/ExamManagementSystem/Admin/ReportFetch");
		request.send();
	});
}
