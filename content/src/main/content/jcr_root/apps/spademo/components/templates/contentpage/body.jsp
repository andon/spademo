<%@include file="/libs/foundation/global.jsp" %><%
%><%@taglib prefix="cq" uri="http://www.day.com/taglibs/cq/1.0" %><%
%><cq:defineObjects/><%
%><body>
 <div id="wrap">
  <div class="container">
    <div class="starter-template">
      <div class="header-wrapper">
        <div class="adaptto logo"></div>
        <div class="intro">
          <h1>AEMSPA Demo</h1>
          <p class="lead">
              This is a Demo project for the adaptTo() 2014 talk:
              <br />
              <b>"Dynamic Components using Single-Page-Application Concepts"</b>
          </p>
        </div>
      </div>
      <cq:include resourceType="foundation/components/parsys" path="par"/>
    </div>
  </div>
  </div>
  <div id="footer">
    <div class="container">
        <p class="muted credit">
          Authors: Andon Sikavica, Bojana Popovska
            <a href="http://http://www.netcetera.com/en/">Netcetera</a>
        </p>
    </div>
  </div>
</body>