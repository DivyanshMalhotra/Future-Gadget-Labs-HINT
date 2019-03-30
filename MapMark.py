from gmplot import gmplot
import serial
import numpy as np
'''
ser = serial.Serial()
ser.port = 'COM1'
ser.open()
dataRec = ser.read() #COM1 has no data, read keep waiting until read one byte.
print(dataRec)
#Divyansh- Make this string if not already
latInd=dataRec.find('/')
longInd=dataRec.find('/',latInd+1)
altInd=dataRec.find('/',longInd+1)
lati=dataRec[latInd:longInd]
longi=dataRec[longInd:AltInd]
'''
# Place map
gmap = gmplot.GoogleMapPlotter(24.4271725, 81.7717986,13)
#Divyansh Uncomment this part and comment the above part if the above code works fine
#gmap = gmplot.GoogleMapPlotter(lati, longi, 13)
'''
# Polygon
golden_gate_park_lats, golden_gate_park_lons = zip(*[
    (37.771269, -122.511015),
    (37.773495, -122.464830),
    (37.774797, -122.454538),
    (37.771988, -122.454018),
    (37.773646, -122.440979),
    (37.772742, -122.440797),
    (37.771096, -122.453889),
    (37.768669, -122.453518),
    (37.766227, -122.460213),
    (37.764028, -122.510347),
    (37.771269, -122.511015)
    ])
gmap.plot(golden_gate_park_lats, golden_gate_park_lons, 'cornflowerblue', edge_width=10)
'''
# Marker
hidden_gem_lat, hidden_gem_lon = 24.4271725, 81.7717986
gmap.marker(hidden_gem_lat, hidden_gem_lon, 'cornflowerblue')
#Divyansh Uncomment this part and comment the above part if the above code works fine
#gmap.marker(lati, longi, 'cornflowerblue')

# Draw
gmap.draw("MeishuMap.html")
