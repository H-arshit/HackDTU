/**
 * Created by arvind on 14/10/17.
 */
var pnr = '123456';
var baggagecount = 2;
var obj = { pnr : pnr,
            baggage_count : baggagecount};
$.post('http://192.168.43.126:3000/pnr/check_in', obj , function (res) {
    console.log(res);
    $('#depap').text(res.departue_dest);
    $('#deptime').text(res.departure_time.substr(11, 5));
    $('#arrap').text(res.arrival_dest);
    $('#arrtime').text(res.arrival_time.substr(11, 5));
    $('#name').text(res.name);
    $('#seat').text(res.seat_no);
    $('#qrcode').qrcode({width: 210,height: 210,text: res.pnr});
    $('#qrcode1').qrcode({width: 190,height: 190,text: res.pnr});
    $('#qrcode2').qrcode({width: 190,height: 190,text: res.pnr});
});