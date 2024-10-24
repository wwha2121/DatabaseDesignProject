/**
 * bootstrap-admin-template - Free Admin Template Based On Twitter Bootstrap 3.x
 * @version 2.4.2
 * @license MIT
 * @link https://github.com/puikinsh/Bootstrap-Admin-Template
 */
'use strict';

;(function ($, Metis) {
    var $button = $('.inner a.btn');
    Metis.metisButton = function () {
        $.each($button, function () {
            $(this).popover({
                placement: 'bottom',
                title: this.innerHTML,
                content: this.outerHTML,
                trigger: Metis.isTouchDevice ? 'touchstart' : 'hover'
            });
        });
    };
    return Metis;
})(jQuery, Metis || {});
"use strict";

;(function ($, Metis) {
  "use strict";

  var d2 = [[0, 3], [1, 8], [2, 5], [3, 13], [4, 1]],
      d3 = [[0, 12], [2, 2], [3, 9], [4, 4]],
      parabola = [],
      parabola2 = [],
      circle = [],
      heartA = [],
      bernoulliA = [],
      human = $("#human"),
      eye = $("#eye"),
      bar = $("#bar"),
      heart = $("#heart"),
      bernoilli = $("#bernoilli");

  function lemniscatex(i) {
    return Math.sqrt(2) * Math.cos(i) / (Math.pow(Math.sin(i), 2) + 1);
  }

  function lemniscatey(i) {
    return Math.sqrt(2) * Math.cos(i) * Math.sin(i) / (Math.pow(Math.sin(i), 2) + 1);
  }
  Metis.MetisChart = function () {
    // Plugin check
    if (!$().plot) {
      throw new Error('flot plugin require form MetisChart');
    }
    // Human charts
    $.plot(human, [{ data: d2, label: 'MAN' }, { data: d3, label: 'WOMAN' }], {
      clickable: true,
      hoverable: true,
      series: {
        lines: {
          show: true,
          fill: true,
          fillColor: {
            colors: [{ opacity: 0.5 }, { opacity: 0.15 }]
          }
        },
        points: { show: true }
      }
    });

    // BAR charts
    $.plot(bar, [{
      data: d2,
      label: 'BAR'
    }], {
      clickable: true,
      hoverable: true,
      series: {
        bars: { show: true, barWidth: 0.6 },
        points: { show: true }
      }
    });

    // EYE charts
    for (var i = -5; i <= 5; i += 0.5) {
      parabola.push([i, Math.pow(i, 2) - 25]);
      parabola2.push([i, -Math.pow(i, 2) + 25]);
    }

    for (var c = -2; c <= 2.1; c += 0.1) {
      circle.push([c, Math.sqrt(400 - c * c * 100)]);
      circle.push([c, -Math.sqrt(400 - c * c * 100)]);
    }

    $.plot(eye, [{ data: parabola2, lines: { show: true, fill: true } }, { data: parabola, lines: { show: true, fill: true } }, { data: circle, lines: { show: true } }]);

    // HEART charts
    for (i = -2; i <= 5; i += 0.01) {
      heartA.push([16 * Math.pow(Math.sin(i), 3), 13 * Math.cos(i) - 5 * Math.cos(2 * i) - 2 * Math.cos(3 * i) - Math.cos(4 * i)]);
    }
    $.plot($("#heart"), [{ data: heartA, label: '<i class="fa fa-heart"></i>', color: '#9A004D' }], {
      series: {
        lines: { show: true, fill: true },
        points: { show: false }
      },
      yaxis: { show: true },
      xaxis: { show: true }
    });
    $('#heart .legendLabel').addClass('animated pulse');
    setInterval(function () {
      $('#heart .legendLabel .fa.fa-heart').toggleClass('fa-2x');
    }, 400);

    // BERNOILLI charts
    for (var k = 0; k <= 2 * Math.PI; k += 0.01) {
      bernoulliA.push([lemniscatex(k), lemniscatey(k)]);
    }
    $.plot($("#bernoilli"), [{ data: bernoulliA, label: 'Lemniscate of Bernoulli', lines: { show: true, fill: true } }]);
  };
  return Metis;
})(jQuery, Metis || {});
'use strict';

;(function ($) {
    "use strict";

    Metis.dashboard = function () {

        //----------- BEGIN SPARKLINE CODE -------------------------*/
        // required jquery.sparkline.min.js*/

        /** This code runs when everything has been loaded on the page */
        /* Inline sparklines take their values from the contents of the tag */
        $('.inlinesparkline').sparkline();

        /* Sparklines can also take their values from the first argument
         passed to the sparkline() function */
        var myvalues = [10, 8, 5, 7, 4, 4, 1];
        $('.dynamicsparkline').sparkline(myvalues);

        /* The second argument gives options such as chart type */
        $('.dynamicbar').sparkline(myvalues, { type: 'bar', barColor: 'green' });

        /* Use 'html' instead of an array of values to pass options
         to a sparkline with data in the tag */
        $('.inlinebar').sparkline('html', { type: 'bar', barColor: 'red' });

        $(".sparkline.bar_week").sparkline([5, 6, 7, 2, 0, -4, -2, 4], {
            type: 'bar',
            height: '40',
            barWidth: 5,
            barColor: '#4d6189',
            negBarColor: '#a20051'
        });

        $(".sparkline.line_day").sparkline([5, 6, 7, 9, 9, 5, 4, 6, 6, 4, 6, 7], {
            type: 'line',
            height: '40',
            drawNormalOnTop: false
        });

        $(".sparkline.pie_week").sparkline([1, 1, 2], {
            type: 'pie',
            width: '40',
            height: '40'
        });

        $('.sparkline.stacked_month').sparkline(['0:2', '2:4', '4:2', '4:1'], {
            type: 'bar',
            height: '40',
            barWidth: 10,
            barColor: '#4d6189',
            negBarColor: '#a20051'
        });
        //----------- END SPARKLINE CODE -------------------------*/


        //----------- BEGIN FULLCALENDAR CODE -------------------------*/

        var date = new Date();
        var d = date.getDate();
        var m = date.getMonth();
        var y = date.getFullYear();

        var calendar = $('#calendar').fullCalendar({
            header: {
                left: 'prev,today,next,',
                center: 'title',
                right: 'month,agendaWeek,agendaDay'
            },
            selectable: true,
            selectHelper: true,
            select: function select(start, end, allDay) {
                var title = prompt('Event Title:');
                if (title) {
                    calendar.fullCalendar('renderEvent', {
                        title: title,
                        start: start,
                        end: end,
                        allDay: allDay
                    }, true // make the event "stick"
                    );
                }
                calendar.fullCalendar('unselect');
            },
            editable: true,
            events: [{
                title: 'All Day Event',
                start: new Date(y, m, 1),
                className: 'label label-success'
            }, {
                title: 'Long Event',
                start: new Date(y, m, d - 5),
                end: new Date(y, m, d - 2),
                className: 'label label-info'
            }, {
                id: 999,
                title: 'Repeating Event',
                start: new Date(y, m, d - 3, 16, 0),
                allDay: false,
                className: 'label label-warning'
            }, {
                id: 999,
                title: 'Repeating Event',
                start: new Date(y, m, d + 4, 16, 0),
                allDay: false,
                className: 'label label-inverse'
            }, {
                title: 'Meeting',
                start: new Date(y, m, d, 10, 30),
                allDay: false,
                className: 'label label-important'
            }, {
                title: 'Lunch',
                start: new Date(y, m, d, 12, 0),
                end: new Date(y, m, d, 14, 0),
                allDay: false
            }, {
                title: 'Birthday Party',
                start: new Date(y, m, d + 1, 19, 0),
                end: new Date(y, m, d + 1, 22, 30),
                allDay: false
            }, {
                title: 'Click for Google',
                start: new Date(y, m, 28),
                end: new Date(y, m, 29),
                url: 'http://google.com/'
            }]
        });
        /*----------- END FULLCALENDAR CODE -------------------------*/

        /*----------- BEGIN CHART CODE -------------------------*/
        var sin = [],
            cos = [];
        for (var i = 0; i < 14; i += 0.5) {
            sin.push([i, Math.sin(i)]);
            cos.push([i, Math.cos(i)]);
        }

        var plot = $.plot($("#trigo"), [{
            data: sin,
            label: "sin(x)",
            points: {
                fillColor: "#4572A7",
                size: 5
            },
            color: '#4572A7'
        }, {
            data: cos,
            label: "cos(x)",
            points: {
                fillColor: "#333",
                size: 35
            },
            color: '#AA4643'
        }], {
            series: {
                lines: {
                    show: true
                },
                points: {
                    show: true
                }
            },
            grid: {
                hoverable: true,
                clickable: true
            },
            yaxis: {
                min: -1.2,
                max: 1.2
            }
        });

        function showTooltip(x, y, contents) {
            $('<div id="tooltip">' + contents + '</div>').css({
                position: 'absolute',
                display: 'none',
                top: y + 5,
                left: x + 5,
                border: '1px solid #fdd',
                padding: '2px',
                'background-color': '#000',
                color: '#fff'
            }).appendTo("body").fadeIn(200);
        }

        var previousPoint = null;
        $("#trigo").bind("plothover", function (event, pos, item) {
            $("#x").text(pos.x.toFixed(2));
            $("#y").text(pos.y.toFixed(2));

            if (item) {
                if (previousPoint !== item.dataIndex) {
                    previousPoint = item.dataIndex;

                    $("#tooltip").remove();
                    var x = item.datapoint[0].toFixed(2),
                        y = item.datapoint[1].toFixed(2);

                    showTooltip(item.pageX, item.pageY, item.series.label + " of " + x + " = " + y);
                }
            } else {
                $("#tooltip").remove();
                previousPoint = null;
            }
        });
        /*----------- END CHART CODE -------------------------*/

        /*----------- BEGIN TABLESORTER CODE -------------------------*/
        /* required jquery.tablesorter.min.js*/
        $(".sortableTable").tablesorter();
        /*----------- END TABLESORTER CODE -------------------------*/
    };
    return Metis;
})(jQuery);
"use strict";

;(function ($) {
    "use strict";

    Metis.formGeneral = function () {

        $('.with-tooltip').tooltip({
            selector: ".input-tooltip"
        });

        /*----------- BEGIN autosize CODE -------------------------*/
        if ($('#autosize').length) {
            $('#autosize').autosize();
        }
        /*----------- END autosize CODE -------------------------*/

        /*----------- BEGIN inputlimiter CODE -------------------------*/
        $('#limiter').inputlimiter({
            limit: 140,
            remText: 'You only have %n character%s remaining...',
            limitText: 'You\'re allowed to input %n character%s into this field.'
        });
        /*----------- END inputlimiter CODE -------------------------*/

        /*----------- BEGIN tagsInput CODE -------------------------*/
        $('#tags').tagsInput();
        /*----------- END tagsInput CODE -------------------------*/

        /*----------- BEGIN chosen CODE -------------------------*/

        $(".chzn-select").chosen();
        $(".chzn-select-deselect").chosen({
            allow_single_deselect: true
        });
        /*----------- END chosen CODE -------------------------*/

        /*----------- BEGIN spinner CODE -------------------------*/
        //     DEPRECATED
        //     $('#spin1').spinner();
        //     $("#spin2").spinner({
        //         step: 0.01,
        //         numberFormat: "n"
        //     });
        //     $("#spin3").spinner({
        //         culture: 'en-US',
        //         min: 5,
        //         max: 2500,
        //         step: 25,
        //         start: 1000,
        //         numberFormat: "C"
        //     });
        /*----------- END spinner CODE -------------------------*/

        /*----------- BEGIN uniform CODE -------------------------*/
        $('.uniform').uniform();
        /*----------- END uniform CODE -------------------------*/

        /*----------- BEGIN validVal CODE -------------------------*/
        $('#validVal').validVal();
        /*----------- END validVal CODE -------------------------*/

        /*----------- BEGIN colorpicker CODE -------------------------*/
        $('#cp1').colorpicker({
            format: 'hex'
        });
        $('#cp2').colorpicker();
        $('#cp3').colorpicker();
        $('#cp4').colorpicker().on('changeColor', function (ev) {
            $('#colorPickerBlock').css('background-color', ev.color.toHex());
        });
        /*----------- END colorpicker CODE -------------------------*/

        /*----------- BEGIN datepicker CODE -------------------------*/
        $('#dp1').datepicker({
            format: 'mm-dd-yyyy'
        });
        $('#dp2').datepicker();
        $('#dp3').datepicker();
        $('#dp3').datepicker();
        $('#dpYears').datepicker();
        $('#dpMonths').datepicker();

        var startDate = new Date(2014, 1, 20);
        var endDate = new Date(2014, 1, 25);
        $('#dp4').datepicker().on('changeDate', function (ev) {
            if (ev.date.valueOf() > endDate.valueOf()) {
                $('#alert').show().find('strong').text('The start date can not be greater then the end date');
            } else {
                $('#alert').hide();
                startDate = new Date(ev.date);
                $('#startDate').text($('#dp4').data('date'));
            }
            $('#dp4').datepicker('hide');
        });
        $('#dp5').datepicker().on('changeDate', function (ev) {
            if (ev.date.valueOf() < startDate.valueOf()) {
                $('#alert').show().find('strong').text('The end date can not be less then the start date');
            } else {
                $('#alert').hide();
                endDate = new Date(ev.date);
                $('#endDate').text($('#dp5').data('date'));
            }
            $('#dp5').datepicker('hide');
        });
        /*----------- END datepicker CODE -------------------------*/

        /*----------- BEGIN daterangepicker CODE -------------------------*/
        $('#reservation').daterangepicker();

        $('#reportrange').daterangepicker({
            ranges: {
                'Today': [moment(), moment()],
                'Yesterday': [moment().subtract('days', 1), moment().subtract('days', 1)],
                'Last 7 Days': [moment().subtract('days', 6), moment()],
                'Last 30 Days': [moment().subtract('days', 29), moment()],
                'This Month': [moment().startOf('month'), moment().endOf('month')],
                'Last Month': [moment().subtract('month', 1).startOf('month'), moment().subtract('month', 1).endOf('month')]
            }
        }, function (start, end) {
            $('#reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
        });
        /*----------- END daterangepicker CODE -------------------------*/

        /*----------- BEGIN timepicker CODE -------------------------*/
        //     DEPRECATED
        // $('.timepicker-default').timepicker();
        //
        // $('.timepicker-24').timepicker({
        //     minuteStep: 1,
        //     showSeconds: true,
        //     showMeridia