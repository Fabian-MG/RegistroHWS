/**
 * RegistroServiceMessageReceiverInOut.java
 *
 * <p>This file was auto-generated from WSDL by the Apache Axis2 version: 1.8.0 Built on : Aug 01,
 * 2021 (07:27:19 HST)
 */
package com.registro;

/** RegistroServiceMessageReceiverInOut message receiver */
public class RegistroServiceMessageReceiverInOut
    extends org.apache.axis2.receivers.AbstractInOutMessageReceiver {

  public void invokeBusinessLogic(
      org.apache.axis2.context.MessageContext msgContext,
      org.apache.axis2.context.MessageContext newMsgContext)
      throws org.apache.axis2.AxisFault {

    try {

      // get the implementation class for the Web Service
      Object obj = getTheImplementationObject(msgContext);

      RegistroServiceSkeleton skel = (RegistroServiceSkeleton) obj;
      // Out Envelop
      org.apache.axiom.soap.SOAPEnvelope envelope = null;
      // Find the axisOperation that has been set by the Dispatch phase.
      org.apache.axis2.description.AxisOperation op =
          msgContext.getOperationContext().getAxisOperation();
      if (op == null) {
        throw new org.apache.axis2.AxisFault(
            "Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
      }

      java.lang.String methodName;
      if ((op.getName() != null)
          && ((methodName =
                  org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(
                      op.getName().getLocalPart()))
              != null)) {

        if ("registrarHorarioOperation".equals(methodName)) {

          com.registro.RegistrarHorarioResponse registrarHorarioResponse5 = null;
          com.registro.RegistrarHorarioRequest wrappedParam =
              (com.registro.RegistrarHorarioRequest)
                  fromOM(
                      msgContext.getEnvelope().getBody().getFirstElement(),
                      com.registro.RegistrarHorarioRequest.class);

          registrarHorarioResponse5 = skel.registrarHorarioOperation(wrappedParam);

          envelope =
              toEnvelope(
                  getSOAPFactory(msgContext),
                  registrarHorarioResponse5,
                  false,
                  new javax.xml.namespace.QName("http://registro.com", "registrarHorarioResponse"));

        } else {
          throw new java.lang.RuntimeException("method not found");
        }

        newMsgContext.setEnvelope(envelope);
      }
    } catch (java.lang.Exception e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  //
  private org.apache.axiom.om.OMElement toOM(
      com.registro.RegistrarHorarioRequest param, boolean optimizeContent)
      throws org.apache.axis2.AxisFault {

    try {
      return param.getOMElement(
          com.registro.RegistrarHorarioRequest.MY_QNAME,
          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  private org.apache.axiom.om.OMElement toOM(
      com.registro.RegistrarHorarioResponse param, boolean optimizeContent)
      throws org.apache.axis2.AxisFault {

    try {
      return param.getOMElement(
          com.registro.RegistrarHorarioResponse.MY_QNAME,
          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
      org.apache.axiom.soap.SOAPFactory factory,
      com.registro.RegistrarHorarioResponse param,
      boolean optimizeContent,
      javax.xml.namespace.QName elementQName)
      throws org.apache.axis2.AxisFault {
    try {
      org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

      emptyEnvelope
          .getBody()
          .addChild(param.getOMElement(com.registro.RegistrarHorarioResponse.MY_QNAME, factory));

      return emptyEnvelope;
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  private com.registro.RegistrarHorarioResponse wrapregistrarHorarioOperation() {
    com.registro.RegistrarHorarioResponse wrappedElement =
        new com.registro.RegistrarHorarioResponse();
    return wrappedElement;
  }

  /** get the default envelope */
  private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory) {
    return factory.getDefaultEnvelope();
  }

  private java.lang.Object fromOM(org.apache.axiom.om.OMElement param, java.lang.Class type)
      throws org.apache.axis2.AxisFault {

    try {

      if (com.registro.RegistrarHorarioRequest.class.equals(type)) {

        javax.xml.stream.XMLStreamReader reader = param.getXMLStreamReaderWithoutCaching();
        java.lang.Object result = com.registro.RegistrarHorarioRequest.Factory.parse(reader);
        reader.close();
        return result;
      }

      if (com.registro.RegistrarHorarioResponse.class.equals(type)) {

        javax.xml.stream.XMLStreamReader reader = param.getXMLStreamReaderWithoutCaching();
        java.lang.Object result = com.registro.RegistrarHorarioResponse.Factory.parse(reader);
        reader.close();
        return result;
      }

    } catch (java.lang.Exception e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
    return null;
  }

  private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
    org.apache.axis2.AxisFault f;
    Throwable cause = e.getCause();
    if (cause != null) {
      f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
    } else {
      f = new org.apache.axis2.AxisFault(e.getMessage());
    }

    return f;
  }
} // end of class
