var coap = require('coap');

var req = coap.request({
	host:"127.0.0.1",
	method:"POST",
	pathname:"device",
	observe:true
})

req.on('response',function(res){
	console.log(res.payload.toString());
})


req.end();
