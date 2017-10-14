/**
 * Created by arvind on 14/10/17.
 */
$('#submit').click(function () {
    var pnr = $('#pnr').val();
    var baggagecount = $('#nobags').val();
    var obj = { pnr : pnr,
        baggage_count : baggagecount};
    $.post('http://localhost:3000/pnr/check_in', obj , function (res) {
        console.log(res);
        $('#depap').text(res.departue_dest);
        $('#deptime').text(res.departure_time.substr(11, 5));
        $('#arrap').text(res.arrival_dest);
        $('#arrtime').text(res.arrival_time.substr(11, 5));
        $('#name').text(res.name);
        $('#seat').text(res.seat_no);
        $('#qrcode').empty();
        $('#qrcode1').empty();
        $('#qrcode2').empty();
        $('#qrcode').qrcode({width: 210,height: 210,text: res.pnr});
        $('#qrcode1').qrcode({width: 150,height: 150,text: res.pnr});
        $('#qrcode2').qrcode({width: 150,height: 150,text: res.pnr});
    });
});