package dulk.baseMan.service.config;

public class DataSourceContextHolder   {

    public enum DataSourceEnum {
        master,slave1,slave2;
    }
    private static final ThreadLocal<DataSourceEnum> CONTEXT_HOLDER = new ThreadLocal<DataSourceEnum>() {

        @Override
        protected DataSourceEnum initialValue() {
            return DataSourceEnum.master;
        }
    };
    public static void setDataSourceType(DataSourceEnum type) {
        CONTEXT_HOLDER.set(type);
    }
    public static DataSourceEnum getDataSourceType() {
        return CONTEXT_HOLDER.get();
    }
    public static void resetDataSourceType() {
        CONTEXT_HOLDER.set(DataSourceEnum.master);
    }
}