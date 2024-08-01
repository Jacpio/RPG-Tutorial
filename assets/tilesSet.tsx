<?xml version="1.0" encoding="UTF-8"?>
<tileset version="1.10" tiledversion="1.11.0" name="tilesSet" tilewidth="32" tileheight="32" tilecount="256" columns="16">
 <image source="tiles.png" width="512" height="512"/>
 <tile id="7">
  <objectgroup draworder="index" id="2">
   <object id="1" x="24.0938" y="24.0625" width="7.96875" height="7.9375"/>
  </objectgroup>
 </tile>
 <tile id="8">
  <objectgroup draworder="index" id="2">
   <object id="1" x="0.00284091" y="24.0341" width="31.9901" height="7.98437"/>
  </objectgroup>
 </tile>
 <tile id="9">
  <objectgroup draworder="index" id="2">
   <object id="1" x="0.0434783" y="25.0435" width="7.86957" height="7"/>
  </objectgroup>
 </tile>
 <tile id="10">
  <objectgroup draworder="index" id="2">
   <object id="1" x="0" y="32">
    <polygon points="0,0 8,0 8,-24 32,-24 32,-32 0,-32 0,0"/>
   </object>
  </objectgroup>
 </tile>
 <tile id="11">
  <objectgroup draworder="index" id="2">
   <object id="1" x="32" y="32">
    <polygon points="0,0 0,-32 -32,-32 -32,-24 -8,-24 -8,0"/>
   </object>
  </objectgroup>
 </tile>
 <tile id="23">
  <objectgroup draworder="index" id="2">
   <object id="1" x="24" y="0" width="8.03125" height="32.0313"/>
  </objectgroup>
 </tile>
 <tile id="25">
  <objectgroup draworder="index" id="2">
   <object id="1" x="0" y="0" width="7.95652" height="32"/>
  </objectgroup>
 </tile>
 <tile id="26">
  <objectgroup draworder="index" id="2">
   <object id="1" x="7.0625" y="0.0625">
    <polygon points="0,-0.0666667 -0.0625,25.6875 24.9306,25.8125 24.9375,31.9417 -7.04861,31.9153 -7,-0.125"/>
   </object>
  </objectgroup>
 </tile>
 <tile id="27">
  <objectgroup draworder="index" id="4">
   <object id="4" x="24.9889" y="-0.0333333">
    <polygon points="0,0 7.01111,0.0333333 7.01111,32.0333 -24.9889,32.0333 -24.9889,24.0333 -0.988889,24.0333 -0.988889,0.0333333"/>
   </object>
  </objectgroup>
 </tile>
 <tile id="39">
  <objectgroup draworder="index" id="2">
   <object id="1" x="24.125" y="-0.0625" width="7.875" height="8.125"/>
  </objectgroup>
 </tile>
 <tile id="40">
  <objectgroup draworder="index" id="2">
   <object id="1" x="0" y="0.0625" width="32" height="7.875"/>
  </objectgroup>
 </tile>
 <tile id="41">
  <objectgroup draworder="index" id="2">
   <object id="1" x="0.00833333" y="0.00555556" width="7.49167" height="8.24444"/>
  </objectgroup>
 </tile>
 <tile id="210">
  <objectgroup draworder="index" id="2">
   <object id="1" x="17" y="6" width="15" height="26"/>
  </objectgroup>
 </tile>
 <tile id="211">
  <objectgroup draworder="index" id="2">
   <object id="1" x="0" y="3" width="32" height="29"/>
  </objectgroup>
 </tile>
 <tile id="212">
  <objectgroup draworder="index" id="2">
   <object id="1" x="0" y="3" width="12" height="29"/>
  </objectgroup>
 </tile>
 <tile id="216">
  <objectgroup draworder="index" id="2">
   <object id="1" x="6" y="7" width="26" height="25"/>
  </objectgroup>
 </tile>
 <tile id="224">
  <objectgroup draworder="index" id="2">
   <object id="1" x="11" y="2" width="21" height="30"/>
  </objectgroup>
 </tile>
 <tile id="225">
  <objectgroup draworder="index" id="2">
   <object id="1" x="0" y="2" width="18" height="30"/>
  </objectgroup>
 </tile>
 <tile id="226">
  <objectgroup draworder="index" id="2">
   <object id="1" x="20" y="0" width="12" height="7"/>
  </objectgroup>
 </tile>
 <tile id="227">
  <objectgroup draworder="index" id="2">
   <object id="1" x="0" y="0" width="32" height="32"/>
  </objectgroup>
 </tile>
 <tile id="228">
  <objectgroup draworder="index" id="2">
   <object id="1" x="0" y="0" width="11" height="6"/>
  </objectgroup>
 </tile>
 <tile id="229">
  <objectgroup draworder="index" id="2">
   <object id="1" x="20" y="9" width="12" height="23"/>
  </objectgroup>
 </tile>
 <tile id="230">
  <objectgroup draworder="index" id="2">
   <object id="1" x="0" y="5" width="16" height="27"/>
  </objectgroup>
 </tile>
 <tile id="231">
  <objectgroup draworder="index" id="2">
   <object id="1" x="21" y="12" width="11" height="20"/>
  </objectgroup>
 </tile>
 <tile id="232">
  <objectgroup draworder="index" id="2">
   <object id="1" x="0" y="0" width="32" height="32"/>
  </objectgroup>
 </tile>
 <tile id="233">
  <objectgroup draworder="index" id="2">
   <object id="1" x="0" y="0" width="15" height="32"/>
  </objectgroup>
 </tile>
 <wangsets>
  <wangset name="Teren" type="corner" tile="-1">
   <wangcolor name="water" color="#ff0000" tile="-1" probability="1"/>
   <wangcolor name="ground" color="#00ff00" tile="-1" probability="1"/>
   <wangtile tileid="2" wangid="0,0,0,2,0,0,0,0"/>
   <wangtile tileid="3" wangid="0,0,0,2,0,2,0,0"/>
   <wangtile tileid="4" wangid="0,0,0,0,0,2,0,0"/>
   <wangtile tileid="5" wangid="0,2,0,0,0,2,0,2"/>
   <wangtile tileid="6" wangid="0,2,0,2,0,0,0,2"/>
   <wangtile tileid="7" wangid="0,0,0,1,0,0,0,0"/>
   <wangtile tileid="8" wangid="0,0,0,1,0,1,0,0"/>
   <wangtile tileid="9" wangid="0,0,0,0,0,1,0,0"/>
   <wangtile tileid="10" wangid="0,1,0,0,0,1,0,1"/>
   <wangtile tileid="11" wangid="0,1,0,1,0,0,0,1"/>
   <wangtile tileid="18" wangid="0,2,0,2,0,0,0,0"/>
   <wangtile tileid="19" wangid="0,2,0,2,0,2,0,2"/>
   <wangtile tileid="20" wangid="0,0,0,0,0,2,0,2"/>
   <wangtile tileid="21" wangid="0,0,0,2,0,2,0,2"/>
   <wangtile tileid="22" wangid="0,2,0,2,0,2,0,0"/>
   <wangtile tileid="23" wangid="0,1,0,1,0,0,0,0"/>
   <wangtile tileid="24" wangid="0,1,0,1,0,1,0,1"/>
   <wangtile tileid="25" wangid="0,0,0,0,0,1,0,1"/>
   <wangtile tileid="26" wangid="0,0,0,1,0,1,0,1"/>
   <wangtile tileid="27" wangid="0,1,0,1,0,1,0,0"/>
   <wangtile tileid="34" wangid="0,2,0,0,0,0,0,0"/>
   <wangtile tileid="35" wangid="0,2,0,0,0,0,0,2"/>
   <wangtile tileid="36" wangid="0,0,0,0,0,0,0,2"/>
   <wangtile tileid="39" wangid="0,1,0,0,0,0,0,0"/>
   <wangtile tileid="40" wangid="0,1,0,0,0,0,0,1"/>
   <wangtile tileid="41" wangid="0,0,0,0,0,0,0,1"/>
  </wangset>
 </wangsets>
</tileset>
