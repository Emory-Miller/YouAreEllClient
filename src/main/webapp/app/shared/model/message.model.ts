import { IChannel } from 'app/shared/model/channel.model';
import { IMember } from 'app/shared/model/member.model';
import { IDirectMessage } from 'app/shared/model/direct-message.model';

export interface IMessage {
  id?: number;
  userId?: number | null;
  channelID?: number | null;
  text?: string | null;
  channels?: IChannel[] | null;
  member?: IMember | null;
  directMessage?: IDirectMessage | null;
}

export const defaultValue: Readonly<IMessage> = {};
