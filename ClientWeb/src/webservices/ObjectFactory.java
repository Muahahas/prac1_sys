
package webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservices package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetTypesOfLocalsResponse_QNAME = new QName("http://webservices/", "getTypesOfLocalsResponse");
    private final static QName _GetStreets_QNAME = new QName("http://webservices/", "getStreets");
    private final static QName _GetCharacteristicsByTypeLocalResponse_QNAME = new QName("http://webservices/", "getCharacteristicsByTypeLocalResponse");
    private final static QName _RemoveLocal_QNAME = new QName("http://webservices/", "removeLocal");
    private final static QName _NewLocalResponse_QNAME = new QName("http://webservices/", "newLocalResponse");
    private final static QName _GetLocals_QNAME = new QName("http://webservices/", "getLocals");
    private final static QName _GetLogByDateAndTypeEvent_QNAME = new QName("http://webservices/", "getLogByDateAndTypeEvent");
    private final static QName _ValidateLocalResponse_QNAME = new QName("http://webservices/", "validateLocalResponse");
    private final static QName _RemoveLocalResponse_QNAME = new QName("http://webservices/", "removeLocalResponse");
    private final static QName _GetTypesOfLocals_QNAME = new QName("http://webservices/", "getTypesOfLocals");
    private final static QName _LocalNotFoundError_QNAME = new QName("http://webservices/", "LocalNotFoundError");
    private final static QName _GetLogByDate_QNAME = new QName("http://webservices/", "getLogByDate");
    private final static QName _GetCharacteristicsByTypeLocal_QNAME = new QName("http://webservices/", "getCharacteristicsByTypeLocal");
    private final static QName _GetLocalById_QNAME = new QName("http://webservices/", "getLocalById");
    private final static QName _DuplicatedLocalError_QNAME = new QName("http://webservices/", "DuplicatedLocalError");
    private final static QName _GetLocalByIdResponse_QNAME = new QName("http://webservices/", "getLocalByIdResponse");
    private final static QName _GetLocalsResponse_QNAME = new QName("http://webservices/", "getLocalsResponse");
    private final static QName _NewLocal_QNAME = new QName("http://webservices/", "newLocal");
    private final static QName _WrongTypeLocalError_QNAME = new QName("http://webservices/", "WrongTypeLocalError");
    private final static QName _GetLevelsOfCharacteristicsResponse_QNAME = new QName("http://webservices/", "getLevelsOfCharacteristicsResponse");
    private final static QName _MissingSearchCriteriaError_QNAME = new QName("http://webservices/", "MissingSearchCriteriaError");
    private final static QName _ValidateLocal_QNAME = new QName("http://webservices/", "validateLocal");
    private final static QName _GetLevelsOfCharacteristics_QNAME = new QName("http://webservices/", "getLevelsOfCharacteristics");
    private final static QName _GetLogTypeEventsResponse_QNAME = new QName("http://webservices/", "getLogTypeEventsResponse");
    private final static QName _WrongAddressError_QNAME = new QName("http://webservices/", "WrongAddressError");
    private final static QName _WrongAccessibilityError_QNAME = new QName("http://webservices/", "WrongAccessibilityError");
    private final static QName _MissingNameError_QNAME = new QName("http://webservices/", "MissingNameError");
    private final static QName _GetLogTypeEvents_QNAME = new QName("http://webservices/", "getLogTypeEvents");
    private final static QName _GetStreetsResponse_QNAME = new QName("http://webservices/", "getStreetsResponse");
    private final static QName _GetLogByDateResponse_QNAME = new QName("http://webservices/", "getLogByDateResponse");
    private final static QName _GetLogByDateAndTypeEventResponse_QNAME = new QName("http://webservices/", "getLogByDateAndTypeEventResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetLogByDateAndTypeEventResponse }
     * 
     */
    public GetLogByDateAndTypeEventResponse createGetLogByDateAndTypeEventResponse() {
        return new GetLogByDateAndTypeEventResponse();
    }

    /**
     * Create an instance of {@link GetLogByDateResponse }
     * 
     */
    public GetLogByDateResponse createGetLogByDateResponse() {
        return new GetLogByDateResponse();
    }

    /**
     * Create an instance of {@link GetLogTypeEvents }
     * 
     */
    public GetLogTypeEvents createGetLogTypeEvents() {
        return new GetLogTypeEvents();
    }

    /**
     * Create an instance of {@link GetStreetsResponse }
     * 
     */
    public GetStreetsResponse createGetStreetsResponse() {
        return new GetStreetsResponse();
    }

    /**
     * Create an instance of {@link MissingNameError }
     * 
     */
    public MissingNameError createMissingNameError() {
        return new MissingNameError();
    }

    /**
     * Create an instance of {@link WrongAccessibilityError }
     * 
     */
    public WrongAccessibilityError createWrongAccessibilityError() {
        return new WrongAccessibilityError();
    }

    /**
     * Create an instance of {@link WrongAddressError }
     * 
     */
    public WrongAddressError createWrongAddressError() {
        return new WrongAddressError();
    }

    /**
     * Create an instance of {@link GetLogTypeEventsResponse }
     * 
     */
    public GetLogTypeEventsResponse createGetLogTypeEventsResponse() {
        return new GetLogTypeEventsResponse();
    }

    /**
     * Create an instance of {@link GetLevelsOfCharacteristics }
     * 
     */
    public GetLevelsOfCharacteristics createGetLevelsOfCharacteristics() {
        return new GetLevelsOfCharacteristics();
    }

    /**
     * Create an instance of {@link ValidateLocal }
     * 
     */
    public ValidateLocal createValidateLocal() {
        return new ValidateLocal();
    }

    /**
     * Create an instance of {@link MissingSearchCriteriaError }
     * 
     */
    public MissingSearchCriteriaError createMissingSearchCriteriaError() {
        return new MissingSearchCriteriaError();
    }

    /**
     * Create an instance of {@link GetLevelsOfCharacteristicsResponse }
     * 
     */
    public GetLevelsOfCharacteristicsResponse createGetLevelsOfCharacteristicsResponse() {
        return new GetLevelsOfCharacteristicsResponse();
    }

    /**
     * Create an instance of {@link WrongTypeLocalError }
     * 
     */
    public WrongTypeLocalError createWrongTypeLocalError() {
        return new WrongTypeLocalError();
    }

    /**
     * Create an instance of {@link GetLocalsResponse }
     * 
     */
    public GetLocalsResponse createGetLocalsResponse() {
        return new GetLocalsResponse();
    }

    /**
     * Create an instance of {@link NewLocal }
     * 
     */
    public NewLocal createNewLocal() {
        return new NewLocal();
    }

    /**
     * Create an instance of {@link GetLocalByIdResponse }
     * 
     */
    public GetLocalByIdResponse createGetLocalByIdResponse() {
        return new GetLocalByIdResponse();
    }

    /**
     * Create an instance of {@link DuplicatedLocalError }
     * 
     */
    public DuplicatedLocalError createDuplicatedLocalError() {
        return new DuplicatedLocalError();
    }

    /**
     * Create an instance of {@link GetLocalById }
     * 
     */
    public GetLocalById createGetLocalById() {
        return new GetLocalById();
    }

    /**
     * Create an instance of {@link GetCharacteristicsByTypeLocal }
     * 
     */
    public GetCharacteristicsByTypeLocal createGetCharacteristicsByTypeLocal() {
        return new GetCharacteristicsByTypeLocal();
    }

    /**
     * Create an instance of {@link GetLogByDate }
     * 
     */
    public GetLogByDate createGetLogByDate() {
        return new GetLogByDate();
    }

    /**
     * Create an instance of {@link LocalNotFoundError }
     * 
     */
    public LocalNotFoundError createLocalNotFoundError() {
        return new LocalNotFoundError();
    }

    /**
     * Create an instance of {@link GetTypesOfLocals }
     * 
     */
    public GetTypesOfLocals createGetTypesOfLocals() {
        return new GetTypesOfLocals();
    }

    /**
     * Create an instance of {@link RemoveLocalResponse }
     * 
     */
    public RemoveLocalResponse createRemoveLocalResponse() {
        return new RemoveLocalResponse();
    }

    /**
     * Create an instance of {@link ValidateLocalResponse }
     * 
     */
    public ValidateLocalResponse createValidateLocalResponse() {
        return new ValidateLocalResponse();
    }

    /**
     * Create an instance of {@link GetLocals }
     * 
     */
    public GetLocals createGetLocals() {
        return new GetLocals();
    }

    /**
     * Create an instance of {@link GetLogByDateAndTypeEvent }
     * 
     */
    public GetLogByDateAndTypeEvent createGetLogByDateAndTypeEvent() {
        return new GetLogByDateAndTypeEvent();
    }

    /**
     * Create an instance of {@link NewLocalResponse }
     * 
     */
    public NewLocalResponse createNewLocalResponse() {
        return new NewLocalResponse();
    }

    /**
     * Create an instance of {@link RemoveLocal }
     * 
     */
    public RemoveLocal createRemoveLocal() {
        return new RemoveLocal();
    }

    /**
     * Create an instance of {@link GetCharacteristicsByTypeLocalResponse }
     * 
     */
    public GetCharacteristicsByTypeLocalResponse createGetCharacteristicsByTypeLocalResponse() {
        return new GetCharacteristicsByTypeLocalResponse();
    }

    /**
     * Create an instance of {@link GetStreets }
     * 
     */
    public GetStreets createGetStreets() {
        return new GetStreets();
    }

    /**
     * Create an instance of {@link GetTypesOfLocalsResponse }
     * 
     */
    public GetTypesOfLocalsResponse createGetTypesOfLocalsResponse() {
        return new GetTypesOfLocalsResponse();
    }

    /**
     * Create an instance of {@link Local }
     * 
     */
    public Local createLocal() {
        return new Local();
    }

    /**
     * Create an instance of {@link Characteristic }
     * 
     */
    public Characteristic createCharacteristic() {
        return new Characteristic();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link LogEvent }
     * 
     */
    public LogEvent createLogEvent() {
        return new LogEvent();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTypesOfLocalsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getTypesOfLocalsResponse")
    public JAXBElement<GetTypesOfLocalsResponse> createGetTypesOfLocalsResponse(GetTypesOfLocalsResponse value) {
        return new JAXBElement<GetTypesOfLocalsResponse>(_GetTypesOfLocalsResponse_QNAME, GetTypesOfLocalsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStreets }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getStreets")
    public JAXBElement<GetStreets> createGetStreets(GetStreets value) {
        return new JAXBElement<GetStreets>(_GetStreets_QNAME, GetStreets.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCharacteristicsByTypeLocalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getCharacteristicsByTypeLocalResponse")
    public JAXBElement<GetCharacteristicsByTypeLocalResponse> createGetCharacteristicsByTypeLocalResponse(GetCharacteristicsByTypeLocalResponse value) {
        return new JAXBElement<GetCharacteristicsByTypeLocalResponse>(_GetCharacteristicsByTypeLocalResponse_QNAME, GetCharacteristicsByTypeLocalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveLocal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "removeLocal")
    public JAXBElement<RemoveLocal> createRemoveLocal(RemoveLocal value) {
        return new JAXBElement<RemoveLocal>(_RemoveLocal_QNAME, RemoveLocal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NewLocalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "newLocalResponse")
    public JAXBElement<NewLocalResponse> createNewLocalResponse(NewLocalResponse value) {
        return new JAXBElement<NewLocalResponse>(_NewLocalResponse_QNAME, NewLocalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLocals }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getLocals")
    public JAXBElement<GetLocals> createGetLocals(GetLocals value) {
        return new JAXBElement<GetLocals>(_GetLocals_QNAME, GetLocals.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLogByDateAndTypeEvent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getLogByDateAndTypeEvent")
    public JAXBElement<GetLogByDateAndTypeEvent> createGetLogByDateAndTypeEvent(GetLogByDateAndTypeEvent value) {
        return new JAXBElement<GetLogByDateAndTypeEvent>(_GetLogByDateAndTypeEvent_QNAME, GetLogByDateAndTypeEvent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateLocalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "validateLocalResponse")
    public JAXBElement<ValidateLocalResponse> createValidateLocalResponse(ValidateLocalResponse value) {
        return new JAXBElement<ValidateLocalResponse>(_ValidateLocalResponse_QNAME, ValidateLocalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveLocalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "removeLocalResponse")
    public JAXBElement<RemoveLocalResponse> createRemoveLocalResponse(RemoveLocalResponse value) {
        return new JAXBElement<RemoveLocalResponse>(_RemoveLocalResponse_QNAME, RemoveLocalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTypesOfLocals }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getTypesOfLocals")
    public JAXBElement<GetTypesOfLocals> createGetTypesOfLocals(GetTypesOfLocals value) {
        return new JAXBElement<GetTypesOfLocals>(_GetTypesOfLocals_QNAME, GetTypesOfLocals.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocalNotFoundError }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "LocalNotFoundError")
    public JAXBElement<LocalNotFoundError> createLocalNotFoundError(LocalNotFoundError value) {
        return new JAXBElement<LocalNotFoundError>(_LocalNotFoundError_QNAME, LocalNotFoundError.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLogByDate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getLogByDate")
    public JAXBElement<GetLogByDate> createGetLogByDate(GetLogByDate value) {
        return new JAXBElement<GetLogByDate>(_GetLogByDate_QNAME, GetLogByDate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCharacteristicsByTypeLocal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getCharacteristicsByTypeLocal")
    public JAXBElement<GetCharacteristicsByTypeLocal> createGetCharacteristicsByTypeLocal(GetCharacteristicsByTypeLocal value) {
        return new JAXBElement<GetCharacteristicsByTypeLocal>(_GetCharacteristicsByTypeLocal_QNAME, GetCharacteristicsByTypeLocal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLocalById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getLocalById")
    public JAXBElement<GetLocalById> createGetLocalById(GetLocalById value) {
        return new JAXBElement<GetLocalById>(_GetLocalById_QNAME, GetLocalById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DuplicatedLocalError }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "DuplicatedLocalError")
    public JAXBElement<DuplicatedLocalError> createDuplicatedLocalError(DuplicatedLocalError value) {
        return new JAXBElement<DuplicatedLocalError>(_DuplicatedLocalError_QNAME, DuplicatedLocalError.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLocalByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getLocalByIdResponse")
    public JAXBElement<GetLocalByIdResponse> createGetLocalByIdResponse(GetLocalByIdResponse value) {
        return new JAXBElement<GetLocalByIdResponse>(_GetLocalByIdResponse_QNAME, GetLocalByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLocalsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getLocalsResponse")
    public JAXBElement<GetLocalsResponse> createGetLocalsResponse(GetLocalsResponse value) {
        return new JAXBElement<GetLocalsResponse>(_GetLocalsResponse_QNAME, GetLocalsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NewLocal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "newLocal")
    public JAXBElement<NewLocal> createNewLocal(NewLocal value) {
        return new JAXBElement<NewLocal>(_NewLocal_QNAME, NewLocal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WrongTypeLocalError }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "WrongTypeLocalError")
    public JAXBElement<WrongTypeLocalError> createWrongTypeLocalError(WrongTypeLocalError value) {
        return new JAXBElement<WrongTypeLocalError>(_WrongTypeLocalError_QNAME, WrongTypeLocalError.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLevelsOfCharacteristicsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getLevelsOfCharacteristicsResponse")
    public JAXBElement<GetLevelsOfCharacteristicsResponse> createGetLevelsOfCharacteristicsResponse(GetLevelsOfCharacteristicsResponse value) {
        return new JAXBElement<GetLevelsOfCharacteristicsResponse>(_GetLevelsOfCharacteristicsResponse_QNAME, GetLevelsOfCharacteristicsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MissingSearchCriteriaError }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "MissingSearchCriteriaError")
    public JAXBElement<MissingSearchCriteriaError> createMissingSearchCriteriaError(MissingSearchCriteriaError value) {
        return new JAXBElement<MissingSearchCriteriaError>(_MissingSearchCriteriaError_QNAME, MissingSearchCriteriaError.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateLocal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "validateLocal")
    public JAXBElement<ValidateLocal> createValidateLocal(ValidateLocal value) {
        return new JAXBElement<ValidateLocal>(_ValidateLocal_QNAME, ValidateLocal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLevelsOfCharacteristics }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getLevelsOfCharacteristics")
    public JAXBElement<GetLevelsOfCharacteristics> createGetLevelsOfCharacteristics(GetLevelsOfCharacteristics value) {
        return new JAXBElement<GetLevelsOfCharacteristics>(_GetLevelsOfCharacteristics_QNAME, GetLevelsOfCharacteristics.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLogTypeEventsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getLogTypeEventsResponse")
    public JAXBElement<GetLogTypeEventsResponse> createGetLogTypeEventsResponse(GetLogTypeEventsResponse value) {
        return new JAXBElement<GetLogTypeEventsResponse>(_GetLogTypeEventsResponse_QNAME, GetLogTypeEventsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WrongAddressError }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "WrongAddressError")
    public JAXBElement<WrongAddressError> createWrongAddressError(WrongAddressError value) {
        return new JAXBElement<WrongAddressError>(_WrongAddressError_QNAME, WrongAddressError.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WrongAccessibilityError }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "WrongAccessibilityError")
    public JAXBElement<WrongAccessibilityError> createWrongAccessibilityError(WrongAccessibilityError value) {
        return new JAXBElement<WrongAccessibilityError>(_WrongAccessibilityError_QNAME, WrongAccessibilityError.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MissingNameError }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "MissingNameError")
    public JAXBElement<MissingNameError> createMissingNameError(MissingNameError value) {
        return new JAXBElement<MissingNameError>(_MissingNameError_QNAME, MissingNameError.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLogTypeEvents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getLogTypeEvents")
    public JAXBElement<GetLogTypeEvents> createGetLogTypeEvents(GetLogTypeEvents value) {
        return new JAXBElement<GetLogTypeEvents>(_GetLogTypeEvents_QNAME, GetLogTypeEvents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStreetsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getStreetsResponse")
    public JAXBElement<GetStreetsResponse> createGetStreetsResponse(GetStreetsResponse value) {
        return new JAXBElement<GetStreetsResponse>(_GetStreetsResponse_QNAME, GetStreetsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLogByDateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getLogByDateResponse")
    public JAXBElement<GetLogByDateResponse> createGetLogByDateResponse(GetLogByDateResponse value) {
        return new JAXBElement<GetLogByDateResponse>(_GetLogByDateResponse_QNAME, GetLogByDateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLogByDateAndTypeEventResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getLogByDateAndTypeEventResponse")
    public JAXBElement<GetLogByDateAndTypeEventResponse> createGetLogByDateAndTypeEventResponse(GetLogByDateAndTypeEventResponse value) {
        return new JAXBElement<GetLogByDateAndTypeEventResponse>(_GetLogByDateAndTypeEventResponse_QNAME, GetLogByDateAndTypeEventResponse.class, null, value);
    }

}
