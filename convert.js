const turf = require('@turf/turf');
const arg = process.argv.slice(2);
// 33.21716125904217, -114.341657597711
const e = turf.point([arg[1], arg[0]]);
// 33.307225, -114.346013
const r = turf.point([arg[3], arg[2]]);
const bearing = turf.rhumbBearing(e, r);
const distance = turf.distance(e, r, {units: 'kilometers'});
console.log(`distance ${distance} bearing ${bearing}`);
// node convert.js 33.21716125904217 -114.341657597711 33.307225 -114.346013