package raven.modal.demo.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.util.StringUtils;
import raven.modal.demo.model.enuns.EnumSexo;

import javax.persistence.EntityManagerFactory;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Utils {
    public static EntityManagerFactory entidade;

    public static LocalDate converterToLocalDate(Date date) {
        try {
            LocalDate localdata = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            return localdata;
        } catch (Exception e) {
            return null;
        }
    }

    public static Date converterToDate(LocalDate dateToConvert) {
        if (!StringUtils.isEmpty(dateToConvert))
            return java.sql.Date.valueOf(dateToConvert);

        return null;
    }

    public static Date transformandoEmDate(String data) {
        Date dat = null;

        if (data.replaceAll("[_/]", "").isEmpty()) {
        } else {
            try {
                DateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
                dat = (Date) formata.parse(data);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return dat;
    }

    public static Date transformaDoBancoEmDate(String data) {
        String[] teste = data.split(" ");

        if (teste.length == 1)
            data += " 00:00:00";

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date parsedDate = dateFormat.parse(data);
            Timestamp timestamp = new Timestamp(parsedDate.getTime());
            return timestamp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String dateToString(Date date, String formato) {
        return new SimpleDateFormat(formato, new Locale("pt", "BR")).format(date);
    }

    public static String dataExtenso(Date date) {
        return new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("pt", "BR")).format(date);
    }

    public static Date subtrairDiasNaData(Date data, int numeroDiasParaSubtrair) {
        return adicionarDiasNaData(data, numeroDiasParaSubtrair * -1);
    }

    public static Date adicionarDiasNaData(Date data, int numeroDiasParaAdicionar) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.add(Calendar.DATE, numeroDiasParaAdicionar);
        return calendar.getTime();
    }

    public static EnumSexo converterSexo(String sexo) {
        if (sexo == null)
            return null;
        if (sexo.startsWith("m") || sexo.startsWith("M"))
            return EnumSexo.MASCULINO;
        else if (sexo.startsWith("f") || sexo.startsWith("F"))
            return EnumSexo.FEMININO;
        else
            return EnumSexo.INDEFINIDO;
    }

    public static String formatarCpf(String cpf) {
        return cpf.replaceAll("[^0-9]", "");
    }

    public static String convertObjectToJson(Object object) throws Exception {
        if (object != null) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

            return mapper.writer().withDefaultPrettyPrinter().writeValueAsString(object);
        }

        return null;
    }

    public static <T> T convertJsonToObject(String json, Class<T> objectConverter) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, objectConverter);
    }

    public static <T> List<T> convertJsonToList(String json, Class<T> clazz) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, clazz));
    }

    public static <T> PageResponse<T> convertJsonToPageResponse(String json, Class<T> clazz) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        return mapper.readValue(json, mapper.getTypeFactory().constructParametricType(PageResponse.class, clazz));
    }
}
