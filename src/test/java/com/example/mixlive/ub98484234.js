function ub98484234(v360b6c09f0, v360b6c09f1, v360b6c09f2) {
    var rk = [39, 11, 25, 35, 31, 36, 16, 41, 10, 39, 11, 25, 35, 31, 36, 16, 41, 10, 39, 11, 25, 35, 31, 36, 16, 41, 10, 39, 11, 25, 35, 31, 36, 16, 41, 10, 39, 11, 25, 35, 31, 36, 16, 41, 10, 39, 11, 25, 35, 31, 36, 16, 41, 10, 39, 11, 25, 35, 31, 36, 16, 41, 10, 39, 11, 25, 35, 31, 36, 16, 41, 10, 39, 11, 25, 35, 31, 36, 16, 41, 10, 39, 11, 25, 35, 31, 36, 16, 41, 10, 39, 11, 25, 35, 31, 36, 16, 41, 10, 39, 11, 25, 35, 31, 36, 16, 41, 10, 39, 11, 25, 35, 31, 36, 16, 41, 10, 39, 11, 25, 35, 31, 36, 16, 41, 10, 39, 11, 25, 35, 31, 36, 16, 41, 10, 39, 11, 25, 35, 31, 36, 16, 41, 10, 39, 11, 25, 35, 31, 36, 16, 41, 10, 39, 11, 25, 35, 31, 36, 16, 41, 10, 39, 11, 25, 35, 31, 36, 16, 41, 10, 39, 11, 25, 35, 31, 36, 16, 41, 10, 39, 11, 25, 35, 31, 36, 16, 41, 10, 39, 11, 25, 35, 31, 36];
    var k2 = [0x5067e2e, 0x366011dc];
    var lk = [0x5067e2e, 0x366011dc];
    var v = v360b6c09f.slice(0);
    var k = [0x3bbe6784, 0x6cd672ae, 0x96496df1, 0xbfe901eb];
    for (var O = 0; O < 390; O++) {
        v[O] ^= 0x1391f9da;
    }
    v[1] = (v[1] >>> (lk[1] % 16)) | (v[1] << (32 - (lk[1] % 16)));
    v[0] += lk[0];
    v[3] = (v[3] >>> (lk[1] % 16)) | (v[3] << (32 - (lk[1] % 16)));
    v[2] -= lk[0];
    v[5] ^= lk[1];
    v[4] ^= lk[0];
    v[7] = (v[7] << (lk[1] % 16)) | (v[7] >>> (32 - (lk[1] % 16)));
    v[6] = (v[6] >>> (lk[0] % 16)) | (v[6] << (32 - (lk[0] % 16)));
    v[9] += lk[1];
    v[8] = (v[8] >>> (lk[0] % 16)) | (v[8] << (32 - (lk[0] % 16)));
    v[11] -= lk[1];
    v[10] += lk[0];
    v[13] = (v[13] >>> (lk[1] % 16)) | (v[13] << (32 - (lk[1] % 16)));
    v[12] ^= lk[0];
    v[15] += lk[1];
    v[14] += lk[0];
    v[17] -= lk[1];
    v[16] -= lk[0];
    v[19] = (v[19] >>> (lk[1] % 16)) | (v[19] << (32 - (lk[1] % 16)));
    v[18] += lk[0];
    v[21] = (v[21] >>> (lk[1] % 16)) | (v[21] << (32 - (lk[1] % 16)));
    v[20] -= lk[0];
    v[23] ^= lk[1];
    v[22] ^= lk[0];
    v[25] = (v[25] << (lk[1] % 16)) | (v[25] >>> (32 - (lk[1] % 16)));
    v[24] = (v[24] >>> (lk[0] % 16)) | (v[24] << (32 - (lk[0] % 16)));
    v[27] += lk[1];
    v[26] = (v[26] >>> (lk[0] % 16)) | (v[26] << (32 - (lk[0] % 16)));
    v[29] -= lk[1];
    v[28] += lk[0];
    v[31] = (v[31] >>> (lk[1] % 16)) | (v[31] << (32 - (lk[1] % 16)));
    v[30] ^= lk[0];
    v[33] += lk[1];
    v[32] += lk[0];
    v[35] -= lk[1];
    v[34] -= lk[0];
    v[37] = (v[37] >>> (lk[1] % 16)) | (v[37] << (32 - (lk[1] % 16)));
    v[36] += lk[0];
    v[39] = (v[39] >>> (lk[1] % 16)) | (v[39] << (32 - (lk[1] % 16)));
    v[38] -= lk[0];
    v[41] ^= lk[1];
    v[40] ^= lk[0];
    v[43] = (v[43] << (lk[1] % 16)) | (v[43] >>> (32 - (lk[1] % 16)));
    v[42] = (v[42] >>> (lk[0] % 16)) | (v[42] << (32 - (lk[0] % 16)));
    v[45] += lk[1];
    v[44] = (v[44] >>> (lk[0] % 16)) | (v[44] << (32 - (lk[0] % 16)));
    v[47] -= lk[1];
    v[46] += lk[0];
    v[49] = (v[49] >>> (lk[1] % 16)) | (v[49] << (32 - (lk[1] % 16)));
    v[48] ^= lk[0];
    v[51] += lk[1];
    v[50] += lk[0];
    v[53] -= lk[1];
    v[52] -= lk[0];
    v[55] = (v[55] >>> (lk[1] % 16)) | (v[55] << (32 - (lk[1] % 16)));
    v[54] += lk[0];
    v[57] = (v[57] >>> (lk[1] % 16)) | (v[57] << (32 - (lk[1] % 16)));
    v[56] -= lk[0];
    v[59] ^= lk[1];
    v[58] ^= lk[0];
    v[61] = (v[61] << (lk[1] % 16)) | (v[61] >>> (32 - (lk[1] % 16)));
    v[60] = (v[60] >>> (lk[0] % 16)) | (v[60] << (32 - (lk[0] % 16)));
    v[63] += lk[1];
    v[62] = (v[62] >>> (lk[0] % 16)) | (v[62] << (32 - (lk[0] % 16)));
    v[65] -= lk[1];
    v[64] += lk[0];
    v[67] = (v[67] >>> (lk[1] % 16)) | (v[67] << (32 - (lk[1] % 16)));
    v[66] ^= lk[0];
    v[69] += lk[1];
    v[68] += lk[0];
    v[71] -= lk[1];
    v[70] -= lk[0];
    v[73] = (v[73] >>> (lk[1] % 16)) | (v[73] << (32 - (lk[1] % 16)));
    v[72] += lk[0];
    v[75] = (v[75] >>> (lk[1] % 16)) | (v[75] << (32 - (lk[1] % 16)));
    v[74] -= lk[0];
    v[77] ^= lk[1];
    v[76] ^= lk[0];
    v[79] = (v[79] << (lk[1] % 16)) | (v[79] >>> (32 - (lk[1] % 16)));
    v[78] = (v[78] >>> (lk[0] % 16)) | (v[78] << (32 - (lk[0] % 16)));
    v[81] += lk[1];
    v[80] = (v[80] >>> (lk[0] % 16)) | (v[80] << (32 - (lk[0] % 16)));
    v[83] -= lk[1];
    v[82] += lk[0];
    v[85] = (v[85] >>> (lk[1] % 16)) | (v[85] << (32 - (lk[1] % 16)));
    v[84] ^= lk[0];
    v[87] += lk[1];
    v[86] += lk[0];
    v[89] -= lk[1];
    v[88] -= lk[0];
    v[91] = (v[91] >>> (lk[1] % 16)) | (v[91] << (32 - (lk[1] % 16)));
    v[90] += lk[0];
    v[93] = (v[93] >>> (lk[1] % 16)) | (v[93] << (32 - (lk[1] % 16)));
    v[92] -= lk[0];
    v[95] ^= lk[1];
    v[94] ^= lk[0];
    v[97] = (v[97] << (lk[1] % 16)) | (v[97] >>> (32 - (lk[1] % 16)));
    v[96] = (v[96] >>> (lk[0] % 16)) | (v[96] << (32 - (lk[0] % 16)));
    v[99] += lk[1];
    v[98] = (v[98] >>> (lk[0] % 16)) | (v[98] << (32 - (lk[0] % 16)));
    v[101] -= lk[1];
    v[100] += lk[0];
    v[103] = (v[103] >>> (lk[1] % 16)) | (v[103] << (32 - (lk[1] % 16)));
    v[102] ^= lk[0];
    v[105] += lk[1];
    v[104] += lk[0];
    v[107] -= lk[1];
    v[106] -= lk[0];
    v[109] = (v[109] >>> (lk[1] % 16)) | (v[109] << (32 - (lk[1] % 16)));
    v[108] += lk[0];
    v[111] = (v[111] >>> (lk[1] % 16)) | (v[111] << (32 - (lk[1] % 16)));
    v[110] -= lk[0];
    v[113] ^= lk[1];
    v[112] ^= lk[0];
    v[115] = (v[115] << (lk[1] % 16)) | (v[115] >>> (32 - (lk[1] % 16)));
    v[114] = (v[114] >>> (lk[0] % 16)) | (v[114] << (32 - (lk[0] % 16)));
    v[117] += lk[1];
    v[116] = (v[116] >>> (lk[0] % 16)) | (v[116] << (32 - (lk[0] % 16)));
    v[119] -= lk[1];
    v[118] += lk[0];
    v[121] = (v[121] >>> (lk[1] % 16)) | (v[121] << (32 - (lk[1] % 16)));
    v[120] ^= lk[0];
    v[123] += lk[1];
    v[122] += lk[0];
    v[125] -= lk[1];
    v[124] -= lk[0];
    v[127] = (v[127] >>> (lk[1] % 16)) | (v[127] << (32 - (lk[1] % 16)));
    v[126] += lk[0];
    v[129] = (v[129] >>> (lk[1] % 16)) | (v[129] << (32 - (lk[1] % 16)));
    v[128] -= lk[0];
    v[131] ^= lk[1];
    v[130] ^= lk[0];
    v[133] = (v[133] << (lk[1] % 16)) | (v[133] >>> (32 - (lk[1] % 16)));
    v[132] = (v[132] >>> (lk[0] % 16)) | (v[132] << (32 - (lk[0] % 16)));
    v[135] += lk[1];
    v[134] = (v[134] >>> (lk[0] % 16)) | (v[134] << (32 - (lk[0] % 16)));
    v[137] -= lk[1];
    v[136] += lk[0];
    v[139] = (v[139] >>> (lk[1] % 16)) | (v[139] << (32 - (lk[1] % 16)));
    v[138] ^= lk[0];
    v[141] += lk[1];
    v[140] += lk[0];
    v[143] -= lk[1];
    v[142] -= lk[0];
    v[145] = (v[145] >>> (lk[1] % 16)) | (v[145] << (32 - (lk[1] % 16)));
    v[144] += lk[0];
    v[147] = (v[147] >>> (lk[1] % 16)) | (v[147] << (32 - (lk[1] % 16)));
    v[146] -= lk[0];
    v[149] ^= lk[1];
    v[148] ^= lk[0];
    v[151] = (v[151] << (lk[1] % 16)) | (v[151] >>> (32 - (lk[1] % 16)));
    v[150] = (v[150] >>> (lk[0] % 16)) | (v[150] << (32 - (lk[0] % 16)));
    v[153] += lk[1];
    v[152] = (v[152] >>> (lk[0] % 16)) | (v[152] << (32 - (lk[0] % 16)));
    v[155] -= lk[1];
    v[154] += lk[0];
    v[157] = (v[157] >>> (lk[1] % 16)) | (v[157] << (32 - (lk[1] % 16)));
    v[156] ^= lk[0];
    v[159] += lk[1];
    v[158] += lk[0];
    v[161] -= lk[1];
    v[160] -= lk[0];
    v[163] = (v[163] >>> (lk[1] % 16)) | (v[163] << (32 - (lk[1] % 16)));
    v[162] += lk[0];
    v[165] = (v[165] >>> (lk[1] % 16)) | (v[165] << (32 - (lk[1] % 16)));
    v[164] -= lk[0];
    v[167] ^= lk[1];
    v[166] ^= lk[0];
    v[169] = (v[169] << (lk[1] % 16)) | (v[169] >>> (32 - (lk[1] % 16)));
    v[168] = (v[168] >>> (lk[0] % 16)) | (v[168] << (32 - (lk[0] % 16)));
    v[171] += lk[1];
    v[170] = (v[170] >>> (lk[0] % 16)) | (v[170] << (32 - (lk[0] % 16)));
    v[173] -= lk[1];
    v[172] += lk[0];
    v[175] = (v[175] >>> (lk[1] % 16)) | (v[175] << (32 - (lk[1] % 16)));
    v[174] ^= lk[0];
    v[177] += lk[1];
    v[176] += lk[0];
    v[179] -= lk[1];
    v[178] -= lk[0];
    v[181] = (v[181] >>> (lk[1] % 16)) | (v[181] << (32 - (lk[1] % 16)));
    v[180] += lk[0];
    v[183] = (v[183] >>> (lk[1] % 16)) | (v[183] << (32 - (lk[1] % 16)));
    v[182] -= lk[0];
    v[185] ^= lk[1];
    v[184] ^= lk[0];
    v[187] = (v[187] << (lk[1] % 16)) | (v[187] >>> (32 - (lk[1] % 16)));
    v[186] = (v[186] >>> (lk[0] % 16)) | (v[186] << (32 - (lk[0] % 16)));
    v[189] += lk[1];
    v[188] = (v[188] >>> (lk[0] % 16)) | (v[188] << (32 - (lk[0] % 16)));
    v[191] -= lk[1];
    v[190] += lk[0];
    v[193] = (v[193] >>> (lk[1] % 16)) | (v[193] << (32 - (lk[1] % 16)));
    v[192] ^= lk[0];
    v[195] += lk[1];
    v[194] += lk[0];
    v[197] -= lk[1];
    v[196] -= lk[0];
    v[199] = (v[199] >>> (lk[1] % 16)) | (v[199] << (32 - (lk[1] % 16)));
    v[198] += lk[0];
    v[201] = (v[201] >>> (lk[1] % 16)) | (v[201] << (32 - (lk[1] % 16)));
    v[200] -= lk[0];
    v[203] ^= lk[1];
    v[202] ^= lk[0];
    v[205] = (v[205] << (lk[1] % 16)) | (v[205] >>> (32 - (lk[1] % 16)));
    v[204] = (v[204] >>> (lk[0] % 16)) | (v[204] << (32 - (lk[0] % 16)));
    v[207] += lk[1];
    v[206] = (v[206] >>> (lk[0] % 16)) | (v[206] << (32 - (lk[0] % 16)));
    v[209] -= lk[1];
    v[208] += lk[0];
    v[211] = (v[211] >>> (lk[1] % 16)) | (v[211] << (32 - (lk[1] % 16)));
    v[210] ^= lk[0];
    v[213] += lk[1];
    v[212] += lk[0];
    v[215] -= lk[1];
    v[214] -= lk[0];
    v[217] = (v[217] >>> (lk[1] % 16)) | (v[217] << (32 - (lk[1] % 16)));
    v[216] += lk[0];
    v[219] = (v[219] >>> (lk[1] % 16)) | (v[219] << (32 - (lk[1] % 16)));
    v[218] -= lk[0];
    v[221] ^= lk[1];
    v[220] ^= lk[0];
    v[223] = (v[223] << (lk[1] % 16)) | (v[223] >>> (32 - (lk[1] % 16)));
    v[222] = (v[222] >>> (lk[0] % 16)) | (v[222] << (32 - (lk[0] % 16)));
    v[225] += lk[1];
    v[224] = (v[224] >>> (lk[0] % 16)) | (v[224] << (32 - (lk[0] % 16)));
    v[227] -= lk[1];
    v[226] += lk[0];
    v[229] = (v[229] >>> (lk[1] % 16)) | (v[229] << (32 - (lk[1] % 16)));
    v[228] ^= lk[0];
    v[231] += lk[1];
    v[230] += lk[0];
    v[233] -= lk[1];
    v[232] -= lk[0];
    v[235] = (v[235] >>> (lk[1] % 16)) | (v[235] << (32 - (lk[1] % 16)));
    v[234] += lk[0];
    v[237] = (v[237] >>> (lk[1] % 16)) | (v[237] << (32 - (lk[1] % 16)));
    v[236] -= lk[0];
    v[239] ^= lk[1];
    v[238] ^= lk[0];
    v[241] = (v[241] << (lk[1] % 16)) | (v[241] >>> (32 - (lk[1] % 16)));
    v[240] = (v[240] >>> (lk[0] % 16)) | (v[240] << (32 - (lk[0] % 16)));
    v[243] += lk[1];
    v[242] = (v[242] >>> (lk[0] % 16)) | (v[242] << (32 - (lk[0] % 16)));
    v[245] -= lk[1];
    v[244] += lk[0];
    v[247] = (v[247] >>> (lk[1] % 16)) | (v[247] << (32 - (lk[1] % 16)));
    v[246] ^= lk[0];
    v[249] += lk[1];
    v[248] += lk[0];
    v[251] -= lk[1];
    v[250] -= lk[0];
    v[253] = (v[253] >>> (lk[1] % 16)) | (v[253] << (32 - (lk[1] % 16)));
    v[252] += lk[0];
    v[255] = (v[255] >>> (lk[1] % 16)) | (v[255] << (32 - (lk[1] % 16)));
    v[254] -= lk[0];
    v[257] ^= lk[1];
    v[256] ^= lk[0];
    v[259] = (v[259] << (lk[1] % 16)) | (v[259] >>> (32 - (lk[1] % 16)));
    v[258] = (v[258] >>> (lk[0] % 16)) | (v[258] << (32 - (lk[0] % 16)));
    v[261] += lk[1];
    v[260] = (v[260] >>> (lk[0] % 16)) | (v[260] << (32 - (lk[0] % 16)));
    v[263] -= lk[1];
    v[262] += lk[0];
    v[265] = (v[265] >>> (lk[1] % 16)) | (v[265] << (32 - (lk[1] % 16)));
    v[264] ^= lk[0];
    v[267] += lk[1];
    v[266] += lk[0];
    v[269] -= lk[1];
    v[268] -= lk[0];
    v[271] = (v[271] >>> (lk[1] % 16)) | (v[271] << (32 - (lk[1] % 16)));
    v[270] += lk[0];
    v[273] = (v[273] >>> (lk[1] % 16)) | (v[273] << (32 - (lk[1] % 16)));
    v[272] -= lk[0];
    v[275] ^= lk[1];
    v[274] ^= lk[0];
    v[277] = (v[277] << (lk[1] % 16)) | (v[277] >>> (32 - (lk[1] % 16)));
    v[276] = (v[276] >>> (lk[0] % 16)) | (v[276] << (32 - (lk[0] % 16)));
    v[279] += lk[1];
    v[278] = (v[278] >>> (lk[0] % 16)) | (v[278] << (32 - (lk[0] % 16)));
    v[281] -= lk[1];
    v[280] += lk[0];
    v[283] = (v[283] >>> (lk[1] % 16)) | (v[283] << (32 - (lk[1] % 16)));
    v[282] ^= lk[0];
    v[285] += lk[1];
    v[284] += lk[0];
    v[287] -= lk[1];
    v[286] -= lk[0];
    v[289] = (v[289] >>> (lk[1] % 16)) | (v[289] << (32 - (lk[1] % 16)));
    v[288] += lk[0];
    v[291] = (v[291] >>> (lk[1] % 16)) | (v[291] << (32 - (lk[1] % 16)));
    v[290] -= lk[0];
    v[293] ^= lk[1];
    v[292] ^= lk[0];
    v[295] = (v[295] << (lk[1] % 16)) | (v[295] >>> (32 - (lk[1] % 16)));
    v[294] = (v[294] >>> (lk[0] % 16)) | (v[294] << (32 - (lk[0] % 16)));
    v[297] += lk[1];
    v[296] = (v[296] >>> (lk[0] % 16)) | (v[296] << (32 - (lk[0] % 16)));
    v[299] -= lk[1];
    v[298] += lk[0];
    v[301] = (v[301] >>> (lk[1] % 16)) | (v[301] << (32 - (lk[1] % 16)));
    v[300] ^= lk[0];
    v[303] += lk[1];
    v[302] += lk[0];
    v[305] -= lk[1];
    v[304] -= lk[0];
    v[307] = (v[307] >>> (lk[1] % 16)) | (v[307] << (32 - (lk[1] % 16)));
    v[306] += lk[0];
    v[309] = (v[309] >>> (lk[1] % 16)) | (v[309] << (32 - (lk[1] % 16)));
    v[308] -= lk[0];
    v[311] ^= lk[1];
    v[310] ^= lk[0];
    v[313] = (v[313] << (lk[1] % 16)) | (v[313] >>> (32 - (lk[1] % 16)));
    v[312] = (v[312] >>> (lk[0] % 16)) | (v[312] << (32 - (lk[0] % 16)));
    v[315] += lk[1];
    v[314] = (v[314] >>> (lk[0] % 16)) | (v[314] << (32 - (lk[0] % 16)));
    v[317] -= lk[1];
    v[316] += lk[0];
    v[319] = (v[319] >>> (lk[1] % 16)) | (v[319] << (32 - (lk[1] % 16)));
    v[318] ^= lk[0];
    v[321] += lk[1];
    v[320] += lk[0];
    v[323] -= lk[1];
    v[322] -= lk[0];
    v[325] = (v[325] >>> (lk[1] % 16)) | (v[325] << (32 - (lk[1] % 16)));
    v[324] += lk[0];
    v[327] = (v[327] >>> (lk[1] % 16)) | (v[327] << (32 - (lk[1] % 16)));
    v[326] -= lk[0];
    v[329] ^= lk[1];
    v[328] ^= lk[0];
    v[331] = (v[331] << (lk[1] % 16)) | (v[331] >>> (32 - (lk[1] % 16)));
    v[330] = (v[330] >>> (lk[0] % 16)) | (v[330] << (32 - (lk[0] % 16)));
    v[333] += lk[1];
    v[332] = (v[332] >>> (lk[0] % 16)) | (v[332] << (32 - (lk[0] % 16)));
    v[335] -= lk[1];
    v[334] += lk[0];
    v[337] = (v[337] >>> (lk[1] % 16)) | (v[337] << (32 - (lk[1] % 16)));
    v[336] ^= lk[0];
    v[339] += lk[1];
    v[338] += lk[0];
    v[341] -= lk[1];
    v[340] -= lk[0];
    v[343] = (v[343] >>> (lk[1] % 16)) | (v[343] << (32 - (lk[1] % 16)));
    v[342] += lk[0];
    v[345] = (v[345] >>> (lk[1] % 16)) | (v[345] << (32 - (lk[1] % 16)));
    v[344] -= lk[0];
    v[347] ^= lk[1];
    v[346] ^= lk[0];
    v[349] = (v[349] << (lk[1] % 16)) | (v[349] >>> (32 - (lk[1] % 16)));
    v[348] = (v[348] >>> (lk[0] % 16)) | (v[348] << (32 - (lk[0] % 16)));
    v[351] += lk[1];
    v[350] = (v[350] >>> (lk[0] % 16)) | (v[350] << (32 - (lk[0] % 16)));
    v[353] -= lk[1];
    v[352] += lk[0];
    v[355] = (v[355] >>> (lk[1] % 16)) | (v[355] << (32 - (lk[1] % 16)));
    v[354] ^= lk[0];
    v[357] += lk[1];
    v[356] += lk[0];
    v[359] -= lk[1];
    v[358] -= lk[0];
    v[361] = (v[361] >>> (lk[1] % 16)) | (v[361] << (32 - (lk[1] % 16)));
    v[360] += lk[0];
    v[363] = (v[363] >>> (lk[1] % 16)) | (v[363] << (32 - (lk[1] % 16)));
    v[362] -= lk[0];
    v[365] ^= lk[1];
    v[364] ^= lk[0];
    v[367] = (v[367] << (lk[1] % 16)) | (v[367] >>> (32 - (lk[1] % 16)));
    v[366] = (v[366] >>> (lk[0] % 16)) | (v[366] << (32 - (lk[0] % 16)));
    v[369] += lk[1];
    v[368] = (v[368] >>> (lk[0] % 16)) | (v[368] << (32 - (lk[0] % 16)));
    v[371] -= lk[1];
    v[370] += lk[0];
    v[373] = (v[373] >>> (lk[1] % 16)) | (v[373] << (32 - (lk[1] % 16)));
    v[372] ^= lk[0];
    v[375] += lk[1];
    v[374] += lk[0];
    v[377] -= lk[1];
    v[376] -= lk[0];
    v[379] = (v[379] >>> (lk[1] % 16)) | (v[379] << (32 - (lk[1] % 16)));
    v[378] += lk[0];
    v[381] = (v[381] >>> (lk[1] % 16)) | (v[381] << (32 - (lk[1] % 16)));
    v[380] -= lk[0];
    v[383] ^= lk[1];
    v[382] ^= lk[0];
    v[385] = (v[385] << (lk[1] % 16)) | (v[385] >>> (32 - (lk[1] % 16)));
    v[384] = (v[384] >>> (lk[0] % 16)) | (v[384] << (32 - (lk[0] % 16)));
    v[387] += lk[1];
    v[386] = (v[386] >>> (lk[0] % 16)) | (v[386] << (32 - (lk[0] % 16)));
    v[389] -= lk[1];
    v[388] += lk[0];
    for (var I = 0; I < 390; I += 2) {
        var i, v0 = v[I] ^ k2[0], v1 = v[I + 1] ^ k2[1], d = 0x9E3779B9, sum = d * rk[I / 2];
        for (i = 0; i < rk[I / 2]; i++) {
            v1 -= (((v0 << 4) ^ (v0 >>> 5)) + v0) ^ (sum + k[(sum >>> 11) & 3]);
            sum -= d;
            v0 -= (((v1 << 4) ^ (v1 >>> 5)) + v1) ^ (sum + k[sum & 3]);
        }
        v[I] = v0 ^ k2[1];
        v[I + 1] = v1 ^ k2[0];
    }
    for (var O = 389; O > 0; O--) {
        v[O] ^= v[O - 1];
    }
    v[0] ^= 0x1391f9da;
    var strc = "";
    for (var i = 0; i < v.length; i++) {
        strc += String.fromCharCode(v[i] & 0xff, v[i] >>> 8 & 0xff, v[i] >>> 16 & 0xff, v[i] >>> 24 & 0xff);
    }
    return strc;
}
var v360b6c09f = [0xef25ebf7, 0xa7205107, 0x46952e9e, 0xb4422fb2, 0x1903522f, 0x8fee1944, 0x8a77ea41, 0xfac20265, 0x418a1133, 0x6e4c81d3, 0x7dc47921, 0x9130e047, 0x564fc371, 0x502aace5, 0x8b47d542, 0xe0d6d623, 0x6c99ea8f, 0xdaa0980a, 0x7827cbdc, 0x829777b6, 0x77b19712, 0x7dbfcb1c, 0xaaafbb74, 0xa8b60edf, 0xacaf10df, 0xfb60ac4c, 0x5c97adbd, 0xb40bf93e, 0x1c79d0fb, 0xaa7935f4, 0x495b10a1, 0x79eb0794, 0x3e78dcc1, 0x7890a3b5, 0xf37c0ca8, 0xc75599a5, 0x94666b8a, 0x9c26753a, 0xeb7ddea3, 0x2bcc342f, 0x50efb564, 0xda0fefe7, 0x742a14e1, 0x7a6dbe07, 0x2528c5dc, 0x5485a517, 0x1896aaf1, 0xa5d30f73, 0x66e75df2, 0x8ea7bbf7, 0xafa59768, 0xf7be9f86, 0xe80bb305, 0xbe19a96, 0x5330ecaf, 0x9b11c13, 0x6a469c07, 0xd4927633, 0x705f6320, 0xb3f3e6a1, 0x2f665ee4, 0x6f5202f6, 0x6ca5030, 0xcdebec61, 0x50e08207, 0xe07a257f, 0x703c474d, 0xc3fb8dde, 0x64d5ca65, 0x35921c82, 0x4a275756, 0xcc712c9c, 0xdeee4bf7, 0xfb77eb0a, 0xaec566a3, 0x92102847, 0x91f03273, 0x780c82de, 0x61b42f42, 0x65b1930a, 0x1de08920, 0xaef17108, 0xd0046ace, 0x3f214a21, 0xbbda340d, 0xe48caef3, 0x184d753, 0x616d2fb3, 0x525f3e4b, 0xf3110fef, 0xfd4fe7a7, 0x39ad443a, 0x850ca50b, 0x87d6513c, 0xf1f1dd8a, 0x20b78d1a, 0x388d9f0e, 0x8c80bfc6, 0xe450a1b6, 0x461c4af5, 0xf7b74b66, 0x4cf66d2c, 0x24d7620, 0x301bf6b, 0xce3d84c5, 0x20825819, 0x57b4e8e0, 0x272ddda0, 0xf1eb41ed, 0x2933846c, 0xa46c96a9, 0x24348d73, 0x5a2016da, 0x87e860d1, 0x82c33940, 0x2423e36c, 0x77e97bc7, 0xe6400cc4, 0xa1c8bc40, 0x2440eefa, 0xab7c4bb6, 0x90fb208b, 0x239f51f4, 0xb4d7b285, 0xdf025c9, 0xd90d2471, 0x480c0871, 0x6f7377d9, 0x5153a1e3, 0x5258e65e, 0x35d70887, 0x2cca6c8f, 0x3d30385e, 0xa973305a, 0x7d149518, 0xc0dbca9e, 0x437b4e65, 0xaede50fd, 0x70ba8dc3, 0x8aebd3b6, 0xf0e63f46, 0xf5631672, 0xb3c916fd, 0x8f94f0ec, 0x854eeb96, 0xa9380491, 0x4fac76b6, 0xa9cd69dd, 0x3b5feeb2, 0x886a7417, 0x5245ca57, 0xda5774eb, 0xfdda98e5, 0x84e9786d, 0xf08f0066, 0xc0db3514, 0xd94535f5, 0x2340426d, 0x12589252, 0x6b4bea8d, 0xfc4fbbca, 0x34af1de, 0xa04a400d, 0xde2ae42c, 0x8666cbfc, 0x44bf634d, 0x1282964, 0xb082eb3a, 0x6d0e708e, 0xce6342ff, 0xc2bb790e, 0x1aad5dda, 0x6031f920, 0x64ce9ff1, 0x8678a0b1, 0xe4955bb9, 0xba9c8fdf, 0xa1a80529, 0x1f8fcca5, 0x2ef928f6, 0x84d4505b, 0x9b879f43, 0x1936ccc3, 0x450fe5eb, 0x18c496a4, 0x366dbdbe, 0xa265bc51, 0x5dc3e321, 0x21bd5b10, 0x62433a1e, 0x4bfe7cd9, 0x5dc20bf, 0x81223e2c, 0xd1d058e1, 0xcd40ad0b, 0x8a5f195a, 0x7e07efb4, 0x712f1a26, 0x175b341a, 0x421ee7d6, 0x1607a629, 0x13d520c4, 0xdde99b35, 0x3d4ebdbd, 0x66f1cd6b, 0xf829ddcc, 0xa68b4da7, 0x51873a99, 0x201664d4, 0xf0819b8a, 0xafcda10b, 0x1a5ce5f6, 0x3c84fc11, 0x889ed8a7, 0xe4a3e078, 0x3fef6d4a, 0x6a4ce18a, 0x22deba2d, 0x1bc957d4, 0xd11ca671, 0xdf184b0a, 0xd985e8be, 0xcc1837bb, 0x331e06ac, 0x6dd7abd5, 0xb738ee8b, 0x9badb392, 0xf6df5458, 0x56d555b0, 0x117a4eee, 0xa76609d1, 0x99c9fac1, 0xe10e7336, 0x6b3e15f, 0xd619f37d, 0xb18afc99, 0x7f430601, 0x65234ef6, 0x91c67c3b, 0x464bcee3, 0xbbe90cc3, 0x2f839b75, 0xa0082a2d, 0x284b21e, 0xc8ebcfda, 0xa0615e6c, 0xdfbd0636, 0x2fb3e41b, 0x9e8ab22e, 0xafe98f80, 0x18ba2c9c, 0xb38c9a76, 0xdc90108f, 0xc19dadab, 0x8f51b904, 0xb08b4bc4, 0xead5ded, 0x212b658a, 0xfc019625, 0x3e51e1cb, 0x1caa774f, 0xcf84ad39, 0xfac395ac, 0xb74a72c5, 0xc8bb9ec, 0x7c90691b, 0x47ca6969, 0x8f91fe5d, 0x602ad3df, 0xa6712763, 0xbbae04f9, 0xe8d71535, 0x79d6ae8b, 0xd567dad4, 0x900b5cbd, 0xf3be1c43, 0xd925f506, 0xf3c9598b, 0x4ab99598, 0xe97a8977, 0x49958527, 0x3039d395, 0x56ba69a9, 0xf92a0277, 0x67d2964, 0x7541bc1f, 0xa155c63a, 0x72888dbd, 0x1808a5fd, 0x3b968a0f, 0x95b05132, 0x1ba62c1e, 0xd8974b16, 0xbde0b5c9, 0xa90ee6c5, 0xc7c67eca, 0x97acc6ff, 0x2719ac58, 0xd4461ad2, 0xa7c5de0, 0x440ee6f8, 0xf57ee100, 0x5c6b91f9, 0x8cd72920, 0xd53218de, 0x9db2a53f, 0xa5d6ff68, 0x6e0b958d, 0x4e2fdc24, 0x79d7e74f, 0x23945996, 0xd43e14e6, 0x348e2e6d, 0x27ff4577, 0xef456109, 0xd2b321d3, 0xf489a158, 0xa4c29da0, 0xe47725a7, 0x4b7de7f2, 0x3d53216c, 0xb12c0a71, 0xfdf38380, 0x2c125f0e, 0xa795c7e7, 0x8700d49, 0xd4ebf585, 0xad9db505, 0xf5c7bdf7, 0x561aa6e2, 0xc0d7d014, 0xc014c73, 0x90570a22, 0x4203b05f, 0x9d3ba81c, 0x4e1f2b1c, 0x91e7b4ca, 0x516e0950, 0x39153b66, 0xd5d0f97c, 0x6a278b15, 0xb274d64, 0xd3e6a187, 0x87180fab, 0x2ab14631, 0x708e5cff, 0x22ce0018, 0x68aa9ceb, 0xec2f9013, 0x98dbc7c8, 0x2fc4f46f, 0x1a9a2816, 0xbde8eb45, 0x4bf1651a, 0x20de4838, 0x76e5c766, 0xbcd91885, 0x8d9277c7, 0x760f249b, 0xf2df54bc, 0xab39f765, 0x1db15aa8, 0x39ef6808, 0x1804e5a6, 0x98906273, 0x84e432a4, 0xdddb6d47, 0x4e0a2d6a, 0xde6cba47, 0x2a88cb96, 0x6d0bc019, 0x32455a6d, 0x104f2933, 0x215b4067, 0xd5b6210d, 0xb791d6e1, 0xff5860b5, 0x605612af, 0xfc00b56c, 0x7524bef0, 0xf203d153, 0x46d5872c, 0x41fb37c3, 0xa55a9a86, 0xa398b662, 0xe5dfeb09, 0x9694e394, 0x44db2390, 0x19935174, 0x906d69ac];
