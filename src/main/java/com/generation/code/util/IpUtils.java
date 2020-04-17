package com.generation.code.util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import javax.websocket.RemoteEndpoint.Async;
import javax.websocket.Session;

public class IpUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(IpUtils.class);

    /**
     * @Author xiongxiaofei
     * @Date 2017/5/3
     * @Desc 获取本机IP
     */
    public static String getLocalIp() {
        String ipAddr = "127.0.0.1";
        try {
            List<String> ip4List = listLocalIp4();
            if (ip4List != null && ip4List.size() > 0) {
                ipAddr = ip4List.get(0);
            }
            LOGGER.info("ipAddr=={}", ipAddr);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
        return ipAddr;
    }

    /**
     * @author xiongxiaofei
     * @date 2017/3/3
     * @intro 获取本机所有IPv4的地址
     */
    public static List<String> listLocalIp4() {
        List<String> localIp4List = new ArrayList<>();
        Enumeration<NetworkInterface> networkInterfaceEnumeration;
        try {
            networkInterfaceEnumeration = NetworkInterface.getNetworkInterfaces();
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            return localIp4List;
        }
        while (networkInterfaceEnumeration.hasMoreElements()) {
            NetworkInterface networkInterface = networkInterfaceEnumeration.nextElement();
            Enumeration<InetAddress> inetAddressEnumeration = networkInterface.getInetAddresses();
            while (inetAddressEnumeration.hasMoreElements()) {
                InetAddress inetAddress = inetAddressEnumeration.nextElement();
                if (inetAddress instanceof Inet4Address) {
                    if (!"127.0.0.1".equals(inetAddress.getHostAddress())) {
                        localIp4List.add(inetAddress.getHostAddress());
                    }
                }
            }
        }
        return localIp4List;
    }

    /**
     * @author xiongxiaofei
     * @date 2017/3/3
     * @intro 获取本机MAC地址
     */
    public static String getLocalMac() {
        // 获取网卡，获取地址
        byte[] mac;
        try {
            mac = NetworkInterface.getByInetAddress(InetAddress.getLocalHost()).getHardwareAddress();
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            return null;
        }
        LOGGER.info("mac数组长度：{}", mac.length);
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < mac.length; i++) {
            if (i != 0) {
                sb.append("-");
            }
            //字节转换为整数
            int temp = mac[i] & 0xff;
            String str = Integer.toHexString(temp);
            LOGGER.info("每8位: {}", str);
            if (str.length() == 1) {
                sb.append("0").append(str);
            } else {
                sb.append(str);
            }
        }
        LOGGER.info("本机MAC地址: {}", sb.toString().toUpperCase());
        return sb.toString().toUpperCase();
    }

    
    /**
	 * 获取客户端真实IP，当有代理服务器时使用该方法获取IP
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * IP地址转为整数形式，首先ipAddress要保证是正确的IP地址
	 * @param ipAddress
	 * @return
	 */
	public static long getIpNum(String ipAddress) {
		String[] ip = ipAddress.split("\\.");
		return Long.parseLong(ip[0]) * 256 * 256 * 256 + Long.parseLong(ip[1]) * 256 * 256 + Long.parseLong(ip[2]) * 256 + Long.parseLong(ip[3]);
	}

	/**
	 * 判断IP是否在某个IP区间段
	 * @param ip
	 * @param begin IP区间段起始IP
	 * @param end IP区间段结束IP
	 * @return
	 */
	public static boolean isInner(long ip, long begin, long end) {
		return ip >= begin && ip <= end;
	}
	
	public static String getIp(Session session) {
		return getRemoteAddress(session).getHostString();
	}
	
	public static InetSocketAddress getRemoteAddress(Session session) {
		if (session == null) {
			return null;
		}
		Async async = session.getAsyncRemote();
		
		//在Tomcat 8.0.x版本有效
//		InetSocketAddress addr = (InetSocketAddress) getFieldInstance(async,"base#sos#socketWrapper#socket#sc#remoteAddress");
		//在Tomcat 8.5以上版本有效
		InetSocketAddress addr = (InetSocketAddress) getFieldInstance(async,"base#socketWrapper#socket#sc#remoteAddress");
		return addr;
	}
 
	private static Object getFieldInstance(Object obj, String fieldPath) {
		String fields[] = fieldPath.split("#");
		for (String field : fields) {
			obj = getField(obj, obj.getClass(), field);
			if (obj == null) {
				return null;
			}
		}
 
		return obj;
	}
 
	private static Object getField(Object obj, Class<?> clazz, String fieldName) {
		for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
			try {
				Field field;
				field = clazz.getDeclaredField(fieldName);
				field.setAccessible(true);
				return field.get(obj);
			} catch (Exception e) {
			}
		}
 
		return null;
	}
}
