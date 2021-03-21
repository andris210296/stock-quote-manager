package com.stockquotemanager.model;

import java.io.Serializable;

public class NotificationJson implements Serializable{

	private static final long serialVersionUID = 7399547870238716218L;
	
	protected String host;
	protected int port;
	
	public static class Builder extends NotificationJson implements Serializable {

		private static final long serialVersionUID = 4273829740659649583L;

		public Builder() {

		}

		public Builder setHost(String host) {
			this.host = host;
			return this;
		}

		public Builder setPort(int port) {
			this.port = port;
			return this;
		}

		public NotificationJson build() {
			NotificationJson notificationJson = new NotificationJson();
			notificationJson.host = this.host;
			notificationJson.port = this.port;
			return notificationJson;
		}
	}
}
