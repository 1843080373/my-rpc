package com.rpc.diyrpc.framework;

import com.rpc.diyrpc.protocol.hessian.HessianProtocol;
import com.rpc.diyrpc.protocol.jetty.JettyProtocol;
import com.rpc.diyrpc.protocol.mq.MQProtocol;
import com.rpc.diyrpc.protocol.netty.NettyProtocol;
import com.rpc.diyrpc.protocol.redis.RedisProtocol;
import com.rpc.diyrpc.protocol.restful.RestfulProtocol;
import com.rpc.diyrpc.protocol.rmi.RMIProtocol;
import com.rpc.diyrpc.protocol.socket.SocketProtocol;
import com.rpc.diyrpc.protocol.tomcat.HttpProtocol;
import com.rpc.diyrpc.protocol.webservice.WebServiceProtocol;

public class ProtocolFactory {

	public static Protocol getProtocol(String type) {
		Protocol protocol = null;
		switch (type) {
		case ProviderProtocol.NETTY:
			protocol=new NettyProtocol();
			break;
		case ProviderProtocol.JETTY:
			protocol = new JettyProtocol();
			break;
		case ProviderProtocol.HTTP:
			protocol = new HttpProtocol();
			break;
		case ProviderProtocol.SOCKET:
			protocol = new SocketProtocol();
			break;
		case ProviderProtocol.RMI:
			protocol = new RMIProtocol();
			break;
		case ProviderProtocol.HESSIAN:
			protocol = new HessianProtocol();
			break;
		case ProviderProtocol.WEBSERVICE:
			protocol = new WebServiceProtocol();
			break;
		case ProviderProtocol.RESTFUL:
			protocol = new RestfulProtocol();
			break;
		case ProviderProtocol.REDIS:
			protocol = new RedisProtocol();
			break;
		case ProviderProtocol.MQ:
			protocol = new MQProtocol();
			break;
		default:
			protocol = new HttpProtocol();
			break;
		}
		return protocol;
	}
}
