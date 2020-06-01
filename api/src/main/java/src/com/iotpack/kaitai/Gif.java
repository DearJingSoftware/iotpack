// This is a generated file! Please edit source .ksy file and use kaitai-struct-compiler to rebuild

package com.iotpack.kaitai;

import io.kaitai.struct.ByteBufferKaitaiStream;
import io.kaitai.struct.KaitaiStruct;
import io.kaitai.struct.KaitaiStream;
import java.io.IOException;

public class Gif extends KaitaiStruct {
    public static Gif fromFile(String fileName) throws IOException {
        return new Gif(new ByteBufferKaitaiStream(fileName));
    }

    public Gif(KaitaiStream _io) {
        this(_io, null, null);
    }

    public Gif(KaitaiStream _io, KaitaiStruct _parent) {
        this(_io, _parent, null);
    }

    public Gif(KaitaiStream _io, KaitaiStruct _parent, Gif _root) {
        super(_io);
        this._parent = _parent;
        this._root = _root == null ? this : _root;
        _read();
    }
    private void _read() {
        this.header = new Header(this._io, this, _root);
        this.logicalScreen = new LogicalScreen(this._io, this, _root);
    }
    public static class Header extends KaitaiStruct {
        public static Header fromFile(String fileName) throws IOException {
            return new Header(new ByteBufferKaitaiStream(fileName));
        }

        public Header(KaitaiStream _io) {
            this(_io, null, null);
        }

        public Header(KaitaiStream _io, Gif _parent) {
            this(_io, _parent, null);
        }

        public Header(KaitaiStream _io, Gif _parent, Gif _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.magic = this._io.ensureFixedContents(new byte[] { 71, 73, 70 });
            this.version = this._io.readBytes(3);
        }
        private byte[] magic;
        private byte[] version;
        private Gif _root;
        private Gif _parent;
        public byte[] magic() { return magic; }
        public byte[] version() { return version; }
        public Gif _root() { return _root; }
        public Gif _parent() { return _parent; }
    }
    public static class LogicalScreen extends KaitaiStruct {
        public static LogicalScreen fromFile(String fileName) throws IOException {
            return new LogicalScreen(new ByteBufferKaitaiStream(fileName));
        }

        public LogicalScreen(KaitaiStream _io) {
            this(_io, null, null);
        }

        public LogicalScreen(KaitaiStream _io, Gif _parent) {
            this(_io, _parent, null);
        }

        public LogicalScreen(KaitaiStream _io, Gif _parent, Gif _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.imageWidth = this._io.readU2le();
            this.imageHeight = this._io.readU2le();
            this.flags = this._io.readU1();
            this.bgColorIndex = this._io.readU1();
            this.pixelAspectRatio = this._io.readU1();
        }
        private int imageWidth;
        private int imageHeight;
        private int flags;
        private int bgColorIndex;
        private int pixelAspectRatio;
        private Gif _root;
        private Gif _parent;
        public int imageWidth() { return imageWidth; }
        public int imageHeight() { return imageHeight; }
        public int flags() { return flags; }
        public int bgColorIndex() { return bgColorIndex; }
        public int pixelAspectRatio() { return pixelAspectRatio; }
        public Gif _root() { return _root; }
        public Gif _parent() { return _parent; }
    }
    private Header header;
    private LogicalScreen logicalScreen;
    private Gif _root;
    private KaitaiStruct _parent;
    public Header header() { return header; }
    public LogicalScreen logicalScreen() { return logicalScreen; }
    public Gif _root() { return _root; }
    public KaitaiStruct _parent() { return _parent; }
}
