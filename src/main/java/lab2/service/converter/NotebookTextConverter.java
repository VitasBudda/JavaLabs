package lab2.service.converter;

import lab2.exception.ConvertException;
import lab2.model.Notebook;
import lab2.service.Converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NotebookTextConverter implements Converter<Notebook> {

    private final String FIELDS_SEPARATOR = "~~";
    private final Integer FIELDS_COUNT = 7;

    private Object[] getSmartPhoneFields(Notebook notebook) {
        return new Object[]{
                notebook.getName(), notebook.getOperatingSystem(), notebook.getDisplayDiagonal(),
                notebook.getMemoryCapacity(), notebook.getRam(), notebook.getWeight(), notebook.getPrice()
        };
    }

    @Override
    public String serializeToString(Notebook smartPhone) throws ConvertException {
        try {
            Object[] smartPhoneFields = getSmartPhoneFields(smartPhone);

            List<String> stringFields = Arrays.stream(smartPhoneFields)
                    .map(Object::toString)
                    .collect(Collectors.toList());

            return String.join(FIELDS_SEPARATOR, stringFields);
        } catch (Exception ex) {
            throw new ConvertException(ex.getMessage());
        }
    }

    @Override
    public Notebook deserializeString(String serializedString) throws ConvertException {
        try {
            String[] stringFields = serializedString.split(FIELDS_SEPARATOR);

            if (stringFields.length != FIELDS_COUNT) {
                throw new Exception("Invalid format of string!");
            }

            return new Notebook.Builder()
                    .setName(stringFields[0])
                    .setOperatingSystem(Notebook.OperatingSystem.valueOf(stringFields[1]))
                    .setDisplayDiagonal(Float.parseFloat(stringFields[2]))
                    .setMemoryCapacity(Integer.parseInt(stringFields[3]))
                    .setRam(Integer.parseInt(stringFields[4]))
                    .setWeight(Float.parseFloat(stringFields[5]))
                    .setPrice(Integer.parseInt(stringFields[6]))
                    .build();

        } catch (Exception ex) {
            throw new ConvertException(ex.getMessage());
        }
    }

}
