const ctx = document.getElementById('lineChart');

new Chart(ctx, {
    type: 'line',
    data: {
        labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'November', 'December'],
        datasets: [{
            label: 'Earnings in Dollars $',
            data: [12000, 19000, 4500, 0, 0, 0, 0, 0, 0, 0, 0, 0],
            borderColor: 'red',
            backgroundColor: 'transparent',
            fill: false,
            borderWidth: 3
        }]
    },
    options: {
      nimation: {
        duration: 1000,
        easing: 'easeInOutQuad',
        animateScale: true,
        animateRotate: true,
        onProgress: function(animation) {
            var chart = this.chart;
            var scale = animation.chart.config.options.scales.xAxes[0].ticks.padding;
            var tickWidth = chart.width - scale;
            chart.config.options.scales.xAxes[0].ticks.padding -= (tickWidth / animation.numSteps);
        }
    },
        responsive: true,
        legend: {
            display: false,
            backgroundColor: 'transparent'
        },
        scales: {
            y: {
                ticks: {
                    stepSize: 50000
                }
            }
        },
        maintainAspectRatio: false
    }
});
