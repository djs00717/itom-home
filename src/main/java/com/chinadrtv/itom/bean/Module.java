package com.chinadrtv.itom.bean;


import com.chinadrtv.itom.util.PropertiesUtil;

public enum Module {
	/** 采购订单模块 */
	PURCHASE_ORDER {
		@Override
		public String getId() {
			return PropertiesUtil.getProperties("purchase.order.module.id");
		}
		@Override
		public String getName() {
			return PropertiesUtil.getProperties("purchase.order.module.name");
		}
		@Override
		public String getMainTableName() {
			return "DOC51BF";
		}
	},
	/** 送货申请单模块 */
	PURCHASE_SEND_APPLY_ORDER {
		@Override
		public String getId() {
			return PropertiesUtil.getProperties("purchase.send.apply.order.module.id");
		}
		@Override
		public String getName() {
			return PropertiesUtil.getProperties("purchase.send.apply.order.module.name");
		}
		@Override
		public String getMainTableName() {
			return "DOC53BF";
		}
	},
	/** 送货单模块 */
	PURCHASE_SEND_ORDER {
		@Override
		public String getId() {
			return PropertiesUtil.getProperties("purchase.send.order.module.id");
		}
		@Override
		public String getName() {
			return PropertiesUtil.getProperties("purchase.send.order.module.name");
		}
		@Override
		public String getMainTableName() {
			return "DOC52BF";
		}
	},
	/** 采购入库单 */
	PURCHASE_IN_STORAGE_ORDER {
		@Override
		public String getId() {
			return PropertiesUtil.getProperties("purchase.in.storage.order.module.id");
		}
		@Override
		public String getName() {
			return PropertiesUtil.getProperties("purchase.in.storage.order.module.name");
		}
		@Override
		public String getMainTableName() {
			return "DOC01BF";
		}
	},
	/** 返修单模块 */
	REPAIR_ORDER {
		@Override
		public String getId() {
			return PropertiesUtil.getProperties("repair.order.module.id");
		}
		@Override
		public String getName() {
			return PropertiesUtil.getProperties("repair.order.module.name");
		}
		@Override
		public String getMainTableName() {
			return "DOC22BF";
		}
	},
	/** 还回申请单模块 */
	REPAIR_BACK_APPLY_ORDER {
		@Override
		public String getId() {
			return PropertiesUtil.getProperties("repair.back.apply.order.module.id");
		}
		@Override
		public String getName() {
			return PropertiesUtil.getProperties("repair.back.apply.order.module.name");
		}
		@Override
		public String getMainTableName() {
			return "DOC53BF";
		}
	},
	/** 还回单模块 */
	REPAIR_BACK_ORDER {
		@Override
		public String getId() {
			return PropertiesUtil.getProperties("repair.back.order.module.id");
		}
		@Override
		public String getName() {
			return PropertiesUtil.getProperties("repair.back.order.module.name");
		}
		@Override
		public String getMainTableName() {
			return "DOC22BF";
		}
	},
	/** 返修入库单 */
	REPAIR_IN_STORAGE_ORDER {
		@Override
		public String getId() {
			return PropertiesUtil.getProperties("repair.in.storage.order.module.id");
		}
		@Override
		public String getName() {
			return PropertiesUtil.getProperties("repair.in.storage.order.module.name");
		}
		@Override
		public String getMainTableName() {
			return "DOC01BF";
		}
	},
	/** 退货单 */
	RETURN_ORDER {
		@Override
		public String getId() {
			return PropertiesUtil.getProperties("return.order.module.id");
		}
		@Override
		public String getName() {
			return PropertiesUtil.getProperties("return.order.module.name");
		}
		@Override
		public String getMainTableName() {
			return "DOC20BF";
		}
	},
	/** 结算单 */
	BALANCE_ORDER {
		@Override
		public String getId() {
			return PropertiesUtil.getProperties("balance.order.module.id");
		}
		@Override
		public String getName() {
			return PropertiesUtil.getProperties("balance.order.module.name");
		}
		@Override
		public String getMainTableName() {
			return "DOC88BF";
		}
	},
	/** 差异单 */
	DIFFERENT_ORDER {
		@Override
		public String getId() {
			return PropertiesUtil.getProperties("different.order.module.id");
		}
		@Override
		public String getName() {
			return PropertiesUtil.getProperties("different.order.module.name");
		}
		@Override
		public String getMainTableName() {
			return "DOC27BF";
		}
	};
	public abstract String getId();
	public abstract String getName();
	public abstract String getMainTableName();
}
