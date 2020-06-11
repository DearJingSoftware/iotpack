var coap = require('coap');
var req = coap.request('coap://[::1]/hello')

req.on('response',function(res){
	console.log(res.payload.toString());
})

req.on("data",function (res) {
	console.log(res.payload);
})

req.end();
